package com.willow.io;

import org.junit.Test;

import java.io.*;
import java.util.Date;

public class TestBuffer {


    //使用字符流复制 文件
    @Test
    public  void bufferedReaderAndbufferedWriter(){

        BufferedReader bufferedReader=null;
        BufferedWriter bufferedWriter=null;
        try{
            bufferedReader=new BufferedReader(new FileReader(new File("BufferedWriter.txt")));
            bufferedWriter =new BufferedWriter(new FileWriter(new File("b.txt")));
            char[] c=new char[20];
            int len;
            while ((len=bufferedReader.read(c))!=-1){
                bufferedWriter.write(c,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedWriter!=null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //使用字符流实现内容读入
    @Test
    public void bufferedReader() throws IOException {
        BufferedReader bufferedReader=null;
        try{
              bufferedReader=new BufferedReader(new FileReader("BufferedWriter.txt"));
              String str="";
              while((str=bufferedReader.readLine())!=null){
                  System.out.println(str);
              }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null)
            bufferedReader.close();
        }

    }

    //使用字符流实现内容的输出
    @Test
    public  void bufferedWriter() throws IOException {
        BufferedWriter bufferedWriter=null;
        try{
            bufferedWriter=new BufferedWriter(new FileWriter("BufferedWriter.txt"));
            String str = "BufferedWriter 测试，" + new Date();
            bufferedWriter.write(str);
            bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            bufferedWriter.close();
        }


    }
    //使用字节流实现内容的输出
    @Test
    public void buffered() throws IOException {
        //FileOutputStream fileOutputStream=new FileOutputStream(new File("buffered.txt"));
        BufferedOutputStream bufferedOutputStream=null;
        try {
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(new File("buffered.txt")));

            String str = "Buffered 测试，" + new Date();
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bufferedOutputStream!=null){
                bufferedOutputStream.close();
            }
        }
    }
}
