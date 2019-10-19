package cn.ztuo.kafka.controller;

import cn.ztuo.kafka.entity.KafkaMessages;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;


/**
 * @Author dupinyan
 * @Description
 * @Date 2019/9/10 18:15
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send() {
        KafkaMessages messages = new KafkaMessages();
        messages.setId(System.currentTimeMillis());
        messages.setMsg("123");
        messages.setSendTime(new Date());
        ListenableFuture<SendResult<String, String>> test0 = kafkaTemplate.send("newtopic", gson.toJson(messages));
    }

}
