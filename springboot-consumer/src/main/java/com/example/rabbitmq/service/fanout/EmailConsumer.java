package com.example.rabbitmq.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = "email.fanout.queue")
@Service
public class EmailConsumer {
    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("email:->" + message);
    }
}
