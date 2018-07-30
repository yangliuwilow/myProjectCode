package com.netty5;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author Administrator
 * @create 2018-07-30 16:49
 */
public class Server {

    public static void main(String[] args) throws InterruptedException {
        //1.第一个线程组是用于接收Client端连接的
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //2.第二个线程组是用于实际的业务处理的
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //3.创建辅助类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //4.绑定两个线程池
        serverBootstrap.group(bossGroup, workerGroup);
        //5.指定NIO的模式，如果是客户端就是NioSocketChannel
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);//TCP的缓冲区设置
        serverBootstrap.option(ChannelOption.SO_SNDBUF, 32 * 1024);//设置发送缓冲的大小
        serverBootstrap.option(ChannelOption.SO_RCVBUF, 32 * 1024);//设置接收缓冲区大小
        serverBootstrap.option(ChannelOption.SO_KEEPALIVE, true);//保持连续
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel sc) throws Exception {
                // 解决粘包方案一：拆包粘包定义结束字符串（第一种解决方案）,_end 拼接在消息结尾
                ByteBuf buf = Unpooled.copiedBuffer("_end".getBytes());
                //在管道中加入结束字符串
                 sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));
                //  sc.pipeline().addLast(new FixedLengthFrameDecoder(200)); 解决粘包方案二：第二种定长
                //定义接收类型为字符串把ByteBuf转成String
                sc.pipeline().addLast(new StringDecoder());
                //在这里配置具体数据接收方法的处理
                sc.pipeline().addLast(new ServerHandler());
            }
        });
        //绑定端口,启动
        ChannelFuture future = serverBootstrap.bind(8080).sync();
        System.out.println("服务器已经启动。。。。");
        future.channel().closeFuture().sync();//等待关闭(程序阻塞在这里等待客户端请求)
        bossGroup.shutdownGracefully();//关闭线程
        workerGroup.shutdownGracefully();//关闭线程
    }


/**
 *
 * 1.在上面这个Server.java中，我们都要定义两个线程池，boss和worker，boss是用于管理连接到server端的client的连接数的线程池，而woeker是用于管理实际操作的线程池。
 * 　　2.ServerBootstrap用一个ServerSocketChannelFactory 来实例化。ServerSocketChannelFactory 有两种选择，一种是NioServerSocketChannelFactory，
 一种是OioServerSocketChannelFactory。 前者使用NIO，后则使用普通的阻塞式IO。它们都需要两个线程池实例作为参数来初始化，一个是boss线程池，一个是worker线程池。
 * 　　3.然后使ServerBookstrap管理boss和worker线程池。并且设置各个缓冲区的大小。
 * 　　4.这里的事件处理类经常会被用来处理一个最近的已经接收的Channel。ChannelInitializer是一个特殊的处理类，
 *    他的目的是帮助使用者配置一个新的Channel。也许你想通过增加一些处理类比如NettyServerHandler来配置一个新的Channel 或者其对应的ChannelPipeline来实现你的网络程序。 当你的程序变的复杂时，可能你会增加更多的处理类到pipline上，然后提取这些匿名类到最顶层的类上。
 * 　　5.在使用原始的encoder、decoder的情况下，Netty发送接收数据都是按照ByteBuf的形式，其它形式都是不合法的。 而在上面这个Socket中，我使用sc.pipeline().addLast()这个方法设置了接收为字符串类型，注意：只能设置接收为字符串类型，发送还是需要发送ByteBuf类型的数据。而且在这里我还设置了以$_为结尾的字符串就代表了本次请求字符串的结束。
 * 　　6.通过b.bind绑定端口，用于监听的端口号。
 */
}

/**
 * 　ServertHandler继承自 ChannelHandlerAdapter，这个类实现了ChannelHandler接口，ChannelHandler提供了许多事件处理的接口方法，然后你可以覆盖这些方法。现在仅仅只需要继承ChannelHandlerAdapter类而不是你自己去实现接口方法。
 */
class ServerHandler extends ChannelHandlerAdapter {

    /**
     * 当通道被调用的时候，执行方法
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("server" + body);//前面已经定义了接收为字符串，这里直接接收字符串就可以
        //服务端给客户端的响应
        String response = " hi client!$_";//发送的数据以定义结束的字符串结尾
        //writeAndFlush 添加到缓冲区，并发送到通道
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));//发送必须还是ByteBuf类型
    }

    /*@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }*/


}
