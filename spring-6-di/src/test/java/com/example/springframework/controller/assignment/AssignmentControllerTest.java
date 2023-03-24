package com.example.springframework.controller.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles
@SpringBootTest
class AssignmentControllerTest {

    @Autowired
    AssignmentController assignmentController;

    @Test
    void sayHello() {
        System.out.println(assignmentController.sayHello());
    }
}