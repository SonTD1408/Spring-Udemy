package com.example.springframework.controller;

import com.example.springframework.services.GreetingService;
import com.example.springframework.services.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello() {
        System.out.println("Im in te controller");
        return greetingService.sayGreeting();
    }
}
