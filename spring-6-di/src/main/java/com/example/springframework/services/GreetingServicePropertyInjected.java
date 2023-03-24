package com.example.springframework.services;

import org.springframework.stereotype.Service;

@Service("propertyService")
public class GreetingServicePropertyInjected implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Friends dont let friends to property injection!!!!";
    }
}
