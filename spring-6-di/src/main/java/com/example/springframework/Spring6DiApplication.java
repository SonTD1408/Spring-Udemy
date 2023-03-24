package com.example.springframework;

import com.example.springframework.controller.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring6DiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Spring6DiApplication.class, args);
        MyController controller = ctx.getBean(MyController.class);
        System.out.println("im in main method");
        System.out.println(controller.sayHello());
    }

}
