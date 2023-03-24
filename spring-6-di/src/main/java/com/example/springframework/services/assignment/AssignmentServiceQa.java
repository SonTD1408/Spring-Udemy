package com.example.springframework.services.assignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("qa")
@Service
public class AssignmentServiceQa implements AssignmentService {
    @Override
    public String sayHello() {
        return "qa";
    }
}
