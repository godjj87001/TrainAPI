package com.eland.trainapi;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloControllerTest {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
