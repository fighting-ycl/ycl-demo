package com.personal.managementTest;

import com.personal.SampleApplication.SampleSpringBootApplicationStarter;
import com.personal.management.activemq.ActivemqConsumer;
import com.personal.management.activemq.ActivemqProducer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : YangChunLong
 * @date : Created in 2019/11/19 21:20
 * @description:
 * @modified By:
 * @version: :
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleSpringBootApplicationStarter.class)
public class ActivemqTest {
    @Autowired
    private ActivemqProducer activemqProducer;
    @Autowired
    private ActivemqConsumer activemqConsumer;
    private String queue = "queue1";
    private String topic = "topic1";
    @Test
    public void testSendMessagePoint(){
        String message = "hello activemq";
        String destination = "queue1";
        Assert.assertEquals(true,activemqProducer.sendMessagePoint(message,destination));
    }
    @Test
    public void testReceiveMessagePoint (){
        String destination = "queue1";
        Assert.assertEquals("hello activemq",activemqConsumer.receiveMessagePoint(destination));
    }
    @Test
    public void testReceiveMessageThreads(){
        activemqConsumer.consumePoint();
    }

    @Test
    public void testProductMessageTopic (){
        activemqProducer.sendMessageTopic("我是一个topic",topic);
    }
    @Test
    public void testConsumerMessageTopic (){
        activemqConsumer.receiveMessageTopic(topic);
    }
    @Test
    public void testMoreConsumeMessage(){
        activemqConsumer.consumeTopic();
    }
}
