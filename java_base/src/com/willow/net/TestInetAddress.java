package com.willow.net;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * InetAddress  代表一个IP 地址
 */
public class TestInetAddress
{
    public static void main(String arg[]){
        try {
            InetAddress inetAddress= InetAddress.getByName("www.baidu.com");
            System.out.println("inetAddress走不开:"+inetAddress);
            System.out.println("HostName:"+inetAddress.getHostName());
            System.out.println("HostAddress:"+inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
