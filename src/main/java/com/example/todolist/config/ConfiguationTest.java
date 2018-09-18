package com.example.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguationTest {

    @Bean
    public Inner getInner() {
        System.out.println("getInner");
        return new Inner();
    }

    @Bean
    public Inner inner() {
        System.out.println("inner");
        return getInner();
    }

    @Bean()
    public Inner inner1() {
        System.out.println("inner1");
        return getInner();
    }

    public class Inner {
        public Inner() {
            System.out.println(toString());
        }
    }

}
