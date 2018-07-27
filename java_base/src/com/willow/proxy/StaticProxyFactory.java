package com.willow.proxy;

/**
 * Created by Administrator on 2018/7/17.
 */
interface Color{
      String sayColor();

}
class Red implements  Color{

    @Override
    public String sayColor() {
        System.out.println("我是被代理对象，红色工厂");
        return "红色";
    }
}
public class StaticProxyFactory implements  Color{
    Color color;
    //创建代理类的对象时，实际传入一个被代理类的对象
    public  StaticProxyFactory(Color color){
        this.color=color;
    }

    @Override
    public String sayColor() {
        System.out.println("代理类开始执行....");
        String returnValue=    color.sayColor();
        System.out.println("##"+returnValue);
        return returnValue;
    }
}
class TestStaticProxy{
    public  static void main(String args[]){
        Red red=new Red();
        StaticProxyFactory staticProxyFactory=new StaticProxyFactory(red);
        staticProxyFactory.sayColor();
    }
}
