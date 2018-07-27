package com.willow.net;

import org.junit.Test;

import java.io.IOException;
import java.net.*;


//UDP  编程
public class TestUDP {


    //发送端
    @Test
    public void send() {
        byte[] b = "您好，我是要发送的数据".getBytes();
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            //创建一个数据报，每一个数据报不能大于64k,都记录着数据信息，发送端的IP,端口，以及要发送的数据
            DatagramPacket pack = new DatagramPacket(b, 0, b.length,
                    InetAddress.getByName("127.0.0.1"), 9090);
            datagramSocket.send(pack);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null)
                datagramSocket.close();
        }
    }


    //接收端
    @Test
    public void receive() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9090);
            byte[] b = new byte[1024];
            DatagramPacket packet = new DatagramPacket(b, 0, b.length);
            ds.receive(packet);
            String str1 = new String(b, 0, b.length);
            System.out.println(str1);
            String str = new String(packet.getData(), 0, packet.getData().length);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }

    }
}
