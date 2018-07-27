package com.willow.classloader;

public class MyClassLoderTest {

    public static void main(String[] args) {

        //打印ClassLoader类的层次结构
        ClassLoader classLoader = MyClassLoderTest.class.getClassLoader();    //获得加载ClassLoaderTest.class这个类的类加载器
        while(classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();    //获得父类加载器的引用
        }
        System.out.println(classLoader);




        //测试自定义类加载器  ，在d:/study 创建HelloWorld.java ，然后编译为HelloWorld.class 文件
        FileSystemClassLoader loader=new FileSystemClassLoader("d:/study");
        FileSystemClassLoader loader2=new FileSystemClassLoader("d:/study");
        try {
            Class<?> c = loader.loadClass("HelloWorld");
            Class<?> c1 = loader.loadClass("HelloWorld");
            Class<?> c3 = loader2.loadClass("HelloWorld");


            Class<?> cString = loader2.loadClass("java.lang.String");
            Class<?> cMyClassLoderTest = loader2.loadClass("com.willow.classloader.MyClassLoderTest");
            System.out.println(c.hashCode()+"##:classLoader"+c.getClassLoader());    //自定义加载器加载
            System.out.println(c1.hashCode());
            System.out.println(c3.hashCode());  //同一个类，不同的加载器加载，JVM 认为也是不相同的类
            System.out.println(cString.hashCode()+"##:classLoader"+cString.getClassLoader());  //引导类加载器
            System.out.println(cMyClassLoderTest.hashCode()+"##:classLoader"+cMyClassLoderTest.getClassLoader());  //系统默认加载器
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
