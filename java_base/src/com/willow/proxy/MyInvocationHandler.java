package com.willow.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface Subject {
    String action(String v);
}

class RealSubject implements Subject {

    @Override
    public String action(String v) {
        System.out.println("我是被代理对象，记得要执行我喲，么么哒~~~"+v);
        return v;
    }
}

/**
 * 动态代理
 */
public class MyInvocationHandler implements InvocationHandler {

    public Object object;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // System.out.println("参数："+args[0]);
        Object returnVal= method.invoke(object,args);
        return returnVal;
    }

    //1、给代理对象实例化，2、返回一个代理类对象
    public Object blind(Object object) {
        this.object = object;
        //  1.传入ClassLoader  2：传入 被代理对象，
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }


}
class TestProxy{
    public static void main(String[] args) {
        //1、创建一个代理类对象
        RealSubject realSubject=new RealSubject();
        //2、创建一个实现了InvocationHandler接口的类对象
        MyInvocationHandler handler=new MyInvocationHandler();
        // 3、调用 blind()方法，动态的返回一个代理类的对象
         Subject subject=(Subject)handler.blind(realSubject);  //subject 为代理类对象
        //调用 InvocationHandler 接口实现类的invoke()方法
         subject.action("willow");

        Red red=new Red();
        Color color=(Color)handler.blind(red);
        color.sayColor();
    }
}
