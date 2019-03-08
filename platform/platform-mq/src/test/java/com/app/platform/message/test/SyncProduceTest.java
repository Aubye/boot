package com.app.platform.message.test;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Test;

public class SyncProduceTest {

    public static final String TOPIC_TEST = "TopicTest";
    public static final String TAG_TEST = "TagA";

    @Test
    public void testPush() throws Exception {
        //Instantiate with a producer group name
        DefaultMQProducer producer = new DefaultMQProducer("test-producer");
        // Specify name server addresses.
        producer.setNamesrvAddr("10.0.251.109:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 100; i++) {
            String message = "Hello RocketMQ " + i;
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message(TOPIC_TEST /* Topic */,
                    TAG_TEST /* Tag */,
                    message.getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }

}
