maven D:/newreapal/myProject/apache-maven-3.3.3-bin/apache-maven-3.3.3
D:\newreapal\myProject\apache-maven-3.3.3-bin\apache-maven-3.3.3\conf\settings.xml


启动zookeeper
进入目录：/usr/java/zookeeper-3.4.6/bin
./zkServer.sh start 


数据库oracle ：willow  ,willow


上传：report-web-boss-1.0.0-SNAPSHOT.war  放在tomcat的webapps下，更名为：report-web-boss.war 然后解压
 


本机启动访问：
http://localhost:9090/report-web-boss/login.do
willow  willow登陆



设置非dubbo启动配置
1.  web.xml
<!--  spring 监听 -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
     <context-param>
        <param-name>contextConfigLocation</param-name>
         <param-value><!--classpath:conf/spring-consumer.xml  , dubbo配置 读取配置-->
         classpath:spring/applicationContext-core.xml      <!-- 非dubbo配置读取provider的xml-->
       </param-value>
    </context-param>

    2 web-boss中pom.xml添加如下配置

    <!-- 合并多个war  通过此插件才可以读取provider下的spring的配置文件  -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-war-plugin</artifactId>
                    <configuration>
                        <packagingExcludes>WEB-INF/web.xml</packagingExcludes>
                    </configuration>
                </plugin>

     3.provider去掉读取dubbo配置
     <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
             <property name="locations">
                 <list>
                     <value>classpath:resources.properties</value>
                     <!--<value>classpath:dubbo.properties</value>  非dubbo时候去掉读取配置项-->
                 </list>
             </property>
         </bean>


 