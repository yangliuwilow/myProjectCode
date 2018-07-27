package com.willow.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dell on 2015/1/26.
 */
public class CoreMain {
    public static void main(String[] strings) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
                "classpath*:spring/spring-provider.xml", "classpath*:spring/applicationContext-core.xml"
        });
        context.start();
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
