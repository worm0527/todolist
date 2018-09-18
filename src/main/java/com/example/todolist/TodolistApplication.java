package com.example.todolist;

import com.example.todolist.listener.MyListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TodolistApplication.class, args);
        SpringApplication application = new SpringApplication(TodolistApplication.class);
        application.addListeners(new MyListener());
        application.run(args);
    }

}
