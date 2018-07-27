package com.willow;

import com.alibaba.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringDubboProvider
 *
 */
public class SpringDubboProvider
{
    public static void main( String[] args )
    {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring-provider.xml","spring-common.xml"});
        context.start();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       // new main();
    }
}
