package cn.ztuo.kafka.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author dupinyan
 * @Description
 * @Date 2019/9/10 18:12
 */
@Data
public class KafkaMessages {

    private Long id;

    private String msg;

    private Date sendTime;
}
