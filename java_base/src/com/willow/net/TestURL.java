package com.willow.net;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

//URL：统一资源定位符，一个URL的对象，对应着互联网上一个资源   ，我们可以通过URL的对象调用器相应的方法，将此资源读取下载
public class TestURL {



    @Test
    public void url(){

        try {
            URL url =new URL("https://www.baidu.com/");
            url.getProtocol() ;
            System.out.println("获取该URL的协议名:"+url.getProtocol());
            System.out.println("获取该URL的主机名:"+url.getHost());
            System.out.println("获取该URL的端口号，如果没有设置端口，返回-1:"+url.getPort());

            System.out.println("获取该URL的文件名，如果没有返回空串:"+url.getFile());
            System.out.println("获取该URL中记录的引用，如果URL不含引用，返回null:"+url.getRef());
            System.out.println("获取该URL的查询信息:"+url.getQuery());

            System.out.println("获取该URL的路径:"+url.getPath());
            System.out.println("获取该URL的权限信息:"+url.getAuthority());
            System.out.println("获得使用者的信息:"+url.getUserInfo());

            //方法openStream()与指定的URL建立连接并返回InputStream类的对象以从这一连接中读取数据
            InputStream inputStream = url.openStream();
            byte [] bytes=new byte[200];
            int len;
            while((len=inputStream.read(bytes))!=-1){
                String str=new String(bytes,0,len);
                System.out.println("###"+str);
            }
            inputStream.close();

            //利用URLConnection实现双向通信  ,即可输入，也可输出
            URLConnection content = url.openConnection();
            InputStream inputStream1 = content.getInputStream();
            //读取数据输出到 本地abc.txt中
            OutputStream outputStream=new FileOutputStream(new File("abc.txt"));
            byte[] bytess=new byte[500];
            int length;
            while((length=inputStream1.read(bytess))!=-1){
                outputStream.write(bytess,0,length);
            }
            outputStream.close();
            inputStream1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
