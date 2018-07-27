package kafka;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/4/19.
 */
public class KafkaProducerTest {
    public static void main(String[] args) {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
                "classpath:spring/spring-kafka-consumer.xml", "classpath:spring/spring-kafka-provider.xml"
        });
        context.start();
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        /*KafkaProducerServer kafkaProducer = new KafkaProducerServer();
        String topic = "orderTopic";
        String value = "test";
        String ifPartition = "1";
        Integer partitionNum = 3;
        String role = "test";//用来生成key
        Map<String,Object> res = kafkaProducer.sndMesForTemplate
                (topic, value, ifPartition, partitionNum, role);

        System.out.println("测试结果如下：===============");
        String message = (String)res.get("message");
        String code = (String)res.get("code");

        System.out.println("code:"+code);
        System.out.println("message:"+message);*/
    }
}
