package com.example.todolist;

import com.example.todolist.entity.Order;
import com.example.todolist.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodolistApplicationTests {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void orderSendTest() {
        Order order = new Order();
        order.setId("20180920000001");
        order.setName("");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        orderSender.send(order);
    }

}
