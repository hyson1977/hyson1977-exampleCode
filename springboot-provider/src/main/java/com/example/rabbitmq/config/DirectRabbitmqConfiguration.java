package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author winterchen 2020/5/19
 */
@Configuration
public class DirectRabbitmqConfiguration {

/*
    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory){
        connectionFactory.setPublisherReturns(true);
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        return rabbitTemplate;
    }

*/

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange", true, false);
    }

    @Bean
    public Queue directemailQueue() {
        return new Queue("email.direct.queue", true);
    }

    @Bean
    public Queue directsmsQueue() {
        return new Queue("sms.direct.queue", true);
    }

    @Bean
    public Binding directsmsBinding() {
        return BindingBuilder.bind(directsmsQueue()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding directemailBinding() {
        return BindingBuilder.bind(directemailQueue()).to(directExchange()).with("email");
    }


}
