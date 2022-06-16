package com.example;

import org.springframework.stereotype.Component;

@Component
public class UserService implements UserInterface {
    @Override
    public void test(){
        System.out.println("test1");
    }

}
