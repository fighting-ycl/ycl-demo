package com.personal.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author : YangChunLong
 * @date : Created in 2019/6/13 23:27
 * @description: rabbit mq 消费者 基础业务类
 * @modified By:
 * @version: :
 */
@Service
@RabbitListener(queues = "testRabbit")
public class RabbitConsumerService {
    @RabbitHandler
    public void consumer (String test){
        System.out.println("test success : "+test);
    }

}
