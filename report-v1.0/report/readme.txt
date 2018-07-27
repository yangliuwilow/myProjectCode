spring 集成dubbo ：
  启动步骤：1    启动spring-dubbo-mybatis-provider
                 1.1  修改db.properties  数据库配置
                 1.2  修改dubbo.properties  中zookeeper注册中心地址
                 1.3  启动SpringDubboProvider 中main方法
           2  启动      spring-dubbo-mybatis-consumer
               2.1   修改spring-consumer.xml      中zookeeper注册中心地址
               2.2   edit configurations -->
                      --->  add maven  tomcat7:run
           3  访问： http://localhost:9090/spring-dubbo-mybatis-consumer/list
