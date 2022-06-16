package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ctrldocker {
    @RequestMapping("/docker")
    public String test() {
        return "hello this is docker!";
    }
}
