package com.app.index.service.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + LocalDateTime.now().toString();
        this.rabbitTemplate.convertAndSend("index-login-logging-queue", context);
    }

}