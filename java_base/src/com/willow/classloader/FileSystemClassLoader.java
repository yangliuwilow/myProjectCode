package com.willow.classloader;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器
 */
public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;  //指定这个类加载器加载的目录  d:/study/

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);//查找这个类是否加载了
        if (c != null) {
            return c;
        }
        ClassLoader parent = this.getParent(); //获取到父类加载器
        try {
            c = parent.loadClass(name); //委派给父类加载
        }catch (ClassNotFoundException e){

        }

        if (c != null) {
            return c;
        } else {
            try {
                byte[] classData=getClassData(name);
                if(classData==null){
                    throw new ClassNotFoundException();
                }else{
                    //方法接受一组字节，然后将其具体化为一个Class类型实例，它一般从磁盘上加载一个文件，然后将文件的字节传递给JVM，通过JVM（native 方法）对于Class的定义，将其具体化，实例化为一个Class类型实例。
                    c=defineClass(name,classData,0,classData.length);
                    return c;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        return c;
    }

    /**
     *   编写读取字节流的方法
     *
     * @param className
     * @return
     * @throws IOException
     */
    private byte[] getClassData(String className) throws IOException {  //com.willow.entity.user   转换为： d:/study/  com/willow/entity/user
        String path = rootDir + "/" + className.replace('.', '/') + ".class";

        InputStream inputStream = null;
        ByteOutputStream outputStream = new ByteOutputStream();
        try {
            inputStream = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, temp);
            }
            return outputStream.toByteArray();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

        return null;
    }
}
