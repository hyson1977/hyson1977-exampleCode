package com.example.rabbitmq.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = "sms.direct.queue")
@Service
public class DirectSmsConsumer {

    @RabbitHandler
    public void reviceMessage(String message) {
        System.out.println("sms:->" + message);
    }
}
