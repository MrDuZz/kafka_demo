package cn.ztuo.kafka;

import cn.ztuo.kafka.controller.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * @Author dupinyan
 * @Description
 * @Date 2019/9/10 17:31
 */
@SpringBootApplication
public class UcenterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UcenterApplication.class, args);
        KafkaSender sender = context.getBean(KafkaSender.class);
        for (int i = 0; i < 1000; i++) {
            sender.send();
            System.out.println("---发送第--"+i+"次");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
