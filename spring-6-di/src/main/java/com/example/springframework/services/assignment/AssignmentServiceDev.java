package com.example.springframework.services.assignment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"dev", "default"})
@Service
public class AssignmentServiceDev implements AssignmentService {
    @Override
    public String sayHello() {
        return "dev";
    }
}
