package com.example.springframework.services.i18n;

import com.example.springframework.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("vn")
@Service("i18n")
public class VietnameseGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Vietnamese";
    }
}
