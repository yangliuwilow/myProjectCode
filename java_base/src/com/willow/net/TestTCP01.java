package com.willow.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestTCP01 {
    //  客户端输入数据，服务端返回输入字符串转换为大写字母
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        Scanner scanner = null;
        InputStream inputStream = null;
        try {
            //1、创建一个流套接字并将其连接到指定主机上的指定端口号。
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9001);
            //2 、返回此套接字的输入流。
            os = socket.getOutputStream();
          /*  System.out.println("请输入多个字符串：");
            scanner = new Scanner(System.in);
            //3、读取输入流
            os.write(scanner.next().getBytes());*/
            os.write("abc".getBytes());
            socket.shutdownOutput();
            //4、接收服务端的数据
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[10];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                System.out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
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
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //1、创建一个流套接字并将其连接到指定 IP 地址的指定端口号。
            serverSocket = new ServerSocket(9001);
            //2、侦听并接受到此套接字的连接。
            socket = serverSocket.accept();
            //3、接收客户端信息
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            String str2 = "";
            while ((len = inputStream.read(bytes)) != -1) {
                String str = new String(bytes, 0, len);
                str2 += str;
                System.out.println(str);
            }
            String strUpperCase = str2.toUpperCase();
            //4、返回给客户端
            outputStream = socket.getOutputStream();
            outputStream.write(strUpperCase.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
