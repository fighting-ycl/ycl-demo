package com.personal.management.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * @author : YangChunLong
 * @date : Created in 2019/11/4 22:06
 * @description: 消费者
 * @modified By:
 * @version: :
 */
@Service
public class Consumer {
//    @JmsListener(destination = "queue1")
    public void receive(String message){
        System.out.println("收到消息： "+message);
    }
}
