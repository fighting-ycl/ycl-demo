package com.personal.management.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @author : YangChunLong
 * @date : Created in 2019/11/4 22:05
 * @description: 生产者
 * @modified By:
 * @version: :
 */
@Service
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

//    @PostConstruct
//    public void init(){
//        jmsTemplate.convertAndSend("queue1","Hello ActiveMQ");
//    }

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        Connection connection = activeMQConnectionFactory.createConnection();
        Session session = connection.createSession();

    }
}
