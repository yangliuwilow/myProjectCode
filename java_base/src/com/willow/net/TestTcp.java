package com.willow.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


//服务端给客户端发送信息，服务端输出信息到控制台
//网络编程实际上就是Socket编程
public class TestTcp {


    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1、创建一个Socket对象，通过构造器指明服务端的IP地址和端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            //2、getOutputStream();以流的形式发送数据，返回 OutputStream 对象
            outputStream = socket.getOutputStream();
            //3、具体输出过程
            outputStream.write("我是客户端，请关照".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4 、关闭相应流和Socket
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //服务端
    @Test
    public void server() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        try {
            //1、创建一个 ServerSocket 的对象，通过构造器指明自身的端口号;
            serverSocket = new ServerSocket(9090);
            //2、调用accept() ；返回一个 Socket对象
            socket = serverSocket.accept(); //这个套接字进行的连接并接受它
            //3、调用Socket对象的getInputStream  获取一个从客户端发送过来的输入流
            inputStream = socket.getInputStream();
            //4、对获取的输入流进行操作
            byte[] bytes = new byte[200];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                System.out.println("str:" + str);
            }
            System.out.println("收到来自于："+socket.getInetAddress().getHostAddress()+"的链接");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭相应的  Socket
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
