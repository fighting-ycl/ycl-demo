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
    @Test
    public void testSendMessage(){
        String message = "hello activemq";
        String destination = "queue1";
        Assert.assertEquals(true,activemqProducer.sendMessage(message,destination));
    }
    @Test
    public void testReceiveMessage (){
        String destination = "queue1";
        Assert.assertEquals("hello activemq",activemqConsumer.receiveMessage(destination));
    }
}
