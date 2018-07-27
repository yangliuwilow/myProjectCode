package com.willow;

import com.willow.entity.User;
import com.willow.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringDubboConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring-consumer.xml"});
        context.start();
        UserService userService = (UserService)context.getBean("userService"); // 获取远程服务代理
        List<User> hello = userService.selectList(new User()); // 执行远程方法
        System.out.println( hello ); // 显示调用结果
    }
}
