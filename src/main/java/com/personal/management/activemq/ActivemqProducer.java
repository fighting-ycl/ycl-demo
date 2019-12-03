package com.personal.management.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;

/**
 * @author : YangChunLong
 * @date : Created in 2019/11/4 22:05
 * @description: 生产者
 * @modified By:
 * @version: :
 */
@Service
public class ActivemqProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

//    @PostConstruct
//    public void init(){
//        jmsTemplate.convertAndSend("queue1","Hello ActiveMQ");
//    }

    private static String BROKER_URL = "tcp://192.168.1.107:61616";
    public boolean sendMessagePoint (String messageStr,String destination){
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        MessageProducer producer;
        try {
            connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Destination destination1 = session.createQueue(destination);
            producer = session.createProducer(destination1);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            TextMessage message = session.createTextMessage(messageStr);
            producer.send(message);
            producer.close();
            session.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean sendMessageTopic (String messageStr, String topicName){
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        MessageProducer producer;
        try {
            connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(topicName);
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            TextMessage message = session.createTextMessage(messageStr);
            producer.send(message);
            System.out.println("发送成功! topic:"+topicName+"...message:"+messageStr);
            producer.close();
            session.close();
            connection.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static void main(String[] args) throws JMSException {
        new ActivemqProducer().sendMessageTopic(" 啊哈哈哈哈哈哈h ","topic1");
    }
}
