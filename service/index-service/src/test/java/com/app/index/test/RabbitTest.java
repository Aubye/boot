package com.app.index.test;

import com.app.index.service.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {

    @Autowired
    private Sender sender;

    @Test
    public void send() {
        sender.send();
    }

}
