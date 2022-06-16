package com.example.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String userId,String produceId,int num){
        String orderId= UUID.randomUUID().toString();
        String exchangeName="fanout_order_exchange";
        rabbitTemplate.convertAndSend(exchangeName,"",orderId);
    }
    public void makeOrder(String routingKey){
        String orderId= UUID.randomUUID().toString();
        String exchangeName="direct_order_exchange";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
    }
}
