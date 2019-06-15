package service;

import mapper.RabbitMq;
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
public class RabbitConsumerService implements RabbitMq<String> {
    @RabbitListener(queues = "test")
    @RabbitHandler
    public void consumer (String test){
        System.out.println("test success : "+test);
    }

    @Override
    public void sendMsg(String s) {

    }

    @Override
    public void receiveMsg(String s) {

    }
}
