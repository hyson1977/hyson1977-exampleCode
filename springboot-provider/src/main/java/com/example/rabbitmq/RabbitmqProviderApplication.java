package com.example.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author winterchen 2020/5/20
 */
@SpringBootApplication
public class RabbitmqProviderApplication {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        SpringApplication.run(RabbitmqProviderApplication.class, args);
    }

}
