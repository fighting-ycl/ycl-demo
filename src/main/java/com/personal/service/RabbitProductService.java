package com.personal.service;

import com.rabbitmq.client.AMQP;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author : YangChunLong
 * @date : Created in 2019/6/13 22:05
 * @description: RabbitMq 生产者 基础业务类
 * @modified By:
 * @version: :
 */
@Service
public class RabbitProductService {
    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String EXCHANGE_B = "my-mq-exchange_B";
    public static final String EXCHANGE_C = "my-mq-exchange_C";

    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";

    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";
    public static final String ROUTINGKEY_B = "spring-boot-routingKey_B";
    public static final String ROUTINGKEY_C = "spring-boot-routingKey_C";

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;


    public void sendMsg (String content){
        Date date = new Date();
        rabbitTemplate.convertAndSend("testRabbit", content+"----"+date);
    }
}
