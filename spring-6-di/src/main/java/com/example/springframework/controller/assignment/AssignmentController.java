package com.example.springframework.controller.assignment;

import com.example.springframework.services.assignment.AssignmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    public String sayHello() {
        return assignmentService.sayHello();
    }
}
