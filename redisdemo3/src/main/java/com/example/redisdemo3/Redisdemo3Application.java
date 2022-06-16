package com.example.redisdemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Redisdemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Redisdemo3Application.class, args);
    }



}
