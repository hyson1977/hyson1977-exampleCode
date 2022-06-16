package com.example.rabbitmq;

import com.example.rabbitmq.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author winterchen 2020/5/20
 */
@SpringBootTest
public class RabbitmqProviderApplicationTest {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("1", "1", 12);
    }

    @Test
    void contextLoads_sms() {
        orderService.makeOrder("sms");
    }
    @Test
    void contextLoads_email() {
        orderService.makeOrder("email");
    }
}
