package com.netty5;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.ReferenceCountUtil;

/**
 * @author Administrator
 * @create 2018-07-30 16:52
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup worker = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(worker)
                .channel(NioSocketChannel.class)

                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        ByteBuf buf = Unpooled.copiedBuffer("_end".getBytes());
                        sc.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, buf));
                        sc.pipeline().addLast(new StringDecoder());
                        sc.pipeline().addLast(new ClientHandler());
                    }
                });
        ChannelFuture f = b.connect("127.0.0.1", 8080).sync();
        f.channel().writeAndFlush(Unpooled.copiedBuffer(" hi say message _end".getBytes()));
        f.channel().writeAndFlush(Unpooled.copiedBuffer(" hi server3_end".getBytes()));
        f.channel().writeAndFlush(Unpooled.copiedBuffer(" hi server4_end".getBytes()));
        f.channel().writeAndFlush(Unpooled.copiedBuffer(" hi server5".getBytes()));
        f.channel().writeAndFlush(Unpooled.copiedBuffer(" hi server6".getBytes()));
        f.channel().closeFuture().sync();
        worker.shutdownGracefully();
    }
}

class ClientHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            System.out.println("client" + msg.toString());
        } finally {
            ReferenceCountUtil.release(msg);//释放缓冲区
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

//粘包：将多个包合并在一起(多个消息内容合并一起发送)
//拆包：将一个包拆分成多个包
