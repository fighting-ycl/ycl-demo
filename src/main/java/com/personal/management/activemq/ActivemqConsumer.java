package com.personal.management.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : YangChunLong
 * @date : Created in 2019/11/4 22:06
 * @description: 消费者
 * @modified By:
 * @version: :
 */
@Service
public class ActivemqConsumer {
//    @JmsListener(destination = "queue1")
//    public void receive(String message){
//        System.out.println("收到消息： "+message);
//    }


    private String BROKER_URL = "tcp://192.168.1.107:61616";
    public String receiveMessagePoint(String destination){
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

    public String receiveMessageTopic (String topicName){
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        MessageConsumer messageConsumer;
        String text ="";
        try{
            connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(topicName);
            messageConsumer = session.createConsumer(destination);
            Message message = messageConsumer.receive();
            text = ((TextMessage)message).getText();
            System.out.println("线程号:"+Thread.currentThread().getName()+"-----收到的信息："+text);
            messageConsumer.close();
            session.close();
            connection.close();
        }catch (Exception e){
            text = "error";
        }
        return text;
    }

//    public void testMsgRecover (){
//        ConnectionFactory connectionFactory;
//        Connection connection
//    }

    public void consumePoint (){
        for (int i = 0; i <3 ; i++) {
            receiveMessagePoint("queue1");
        }
    }

    public void consumeTopic (){
        new Thread(new Runnable() {
            @Override
            public void run() {
                receiveMessageTopic("topic1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                receiveMessageTopic("topic1");
            }
        }).start();
    }

    public static void main(String[] args) {
        new Thread(()->new ActivemqConsumer().receiveMessageTopic("topic1")).start();
        new Thread(()->new ActivemqConsumer().receiveMessageTopic("topic1")).start();
    }
}
