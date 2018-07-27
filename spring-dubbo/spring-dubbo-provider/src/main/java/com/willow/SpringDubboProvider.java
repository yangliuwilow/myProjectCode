package com.willow;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;

/**
 * SpringDubboProvider
 *
 */
public class SpringDubboProvider
{
    public static void main( String[] args )
    {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring-provider.xml"});
        context.start();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       /* Resource[] resources = new Resource[0];
        try {
            resources = new ClassPathXmlApplicationContext().getResources("spring-provider.xml");
            InputStream inputStream =resources[0].getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }*/
     }
}
