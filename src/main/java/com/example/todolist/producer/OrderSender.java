package com.example.todolist.producer;

import com.example.todolist.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) {
        CorrelationData correlationData = new CorrelationData(); // 消息唯一id
        correlationData.setId(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange", "order.abc", order, correlationData);
    }

}
