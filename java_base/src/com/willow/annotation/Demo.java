package com.willow.annotation;


import java.lang.annotation.Annotation;

@MyAnnotation(value = "123",name = "willow")
public class Demo {

    public static void main(String[] args) {
        Demo demo=new Demo();
        Annotation[] annotation = Demo.class.getAnnotations();
        System.out.println("#######"+annotation.length);

        MyAnnotation myAnnotation=Demo.class.getAnnotation(MyAnnotation.class);
        System.out.println("value:"+myAnnotation.name()+myAnnotation.value());

        System.out.println("simpleName:"+Demo.class.getSimpleName());
        Annotation[] declaredAnnotations = Demo.class.getDeclaredAnnotations();
        System.out.println("simpleName:"+Demo.class.getTypeName());
    }
}
