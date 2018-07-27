package com.willow.annotation;

import java.io.File;

public class Demo2 {
    public static void main(String[] args) {
       /* Demo demo=new Demo();
        Annotation[] a = demo.getClass().getAnnotations();
        System.out.println("#######"+demo.getClass().getAnnotations().length);*/
        /*for (int i=0;i<annotations.length;i++){
            System.out.println("#######"+annotations[i]);
        }*/
       updateFileNames("D:\\JAVA\\MySQL DBA从小白到大神实战");


    }


    public static void updateFileNames(String url){
        File file = new File(url);
        //判断文件目录是否存在，且是文件目录，非文件
        if(file.exists() && file.isDirectory()){
            File[] childFiles = file.listFiles();
            String path = file.getAbsolutePath();

            for(File childFile : childFiles){
                if(childFile.isDirectory()){//如果是文件夹
                    String oldName = childFile.getName();
                    String newName = oldName.replace("[www.52yzzy.com 吾爱优质资源网]","");
                    childFile.renameTo(new File(path + "\\" +  newName));
                    updateFileNames(path + "\\" +  newName);
                }

                //如果是文件
                if(childFile.isFile()){
                    String oldName = childFile.getName();
                    if(oldName.endsWith(".mp4")){

                         String parentFileName=childFile.getParentFile().getName();
                         String  parent= " "+parentFileName.substring(parentFileName.indexOf(".")+1,parentFileName.length());
                         String index=parentFileName.substring(0,parentFileName.indexOf("."));

                        String newName = index+"-"+oldName+"";
                        childFile.renameTo(new File(path + "\\" +  newName.replace(".",parent+".")));

                    }else{
                        String newName = oldName.replace("[www.52yzzy.com 吾爱优质资源网]","");
                        childFile.renameTo(new File(path + "\\" +  newName));
                    }
                   // String newName = oldName.substring(oldName.indexOf(index));

                }
            }
        }

    }
}
