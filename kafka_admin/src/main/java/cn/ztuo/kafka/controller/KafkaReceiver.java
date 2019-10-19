package cn.ztuo.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author dupinyan
 * @Description
 * @Date 2019/9/10 18:20
 */
@Component
public class KafkaReceiver {

    @KafkaListener(topics = {"newtopic"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("record = "+ record);
            System.out.println("message = "+ message);
        }
    }
}
