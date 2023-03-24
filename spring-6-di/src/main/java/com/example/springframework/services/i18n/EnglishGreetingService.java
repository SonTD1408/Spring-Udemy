package com.example.springframework.services.i18n;

import com.example.springframework.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"en", "default"})
@Service("i18n")
public class EnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "English";
    }
}
