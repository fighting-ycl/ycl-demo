package com.personal.management.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * @author : YangChunLong
 * @date : Created in 2019/11/4 22:06
 * @description: 消费者
 * @modified By:
 * @version: :
 */
@Service
public class ActivemqConsumer {
    @JmsListener(destination = "queue1")
    public void receive(String message){
        System.out.println("收到消息： "+message);
    }

    private String BROKER_URL = "tcp://192.168.1.107:61616";
    public String receiveMessage(String destination){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection;
        Session session;
        MessageConsumer messageConsumer;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Destination destination1 = session.createQueue(destination);
            messageConsumer = session.createConsumer(destination1);
            Message message = messageConsumer.receive();
            if (message instanceof TextMessage){
                System.out.println("接收到文本消息："+((TextMessage) message).getText());
                return ((TextMessage) message).getText();
            }else {
                System.out.println(message);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
