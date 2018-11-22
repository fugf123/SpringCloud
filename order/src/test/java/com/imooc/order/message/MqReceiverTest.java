package com.imooc.order.message;

import com.imooc.order.OrderApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;
@Slf4j
@Component
public class MqReceiverTest extends OrderApplicationTests{

    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send() {
        amqpTemplate.convertAndSend("myQueue","date:"+System.currentTimeMillis());
    }
    public void sendComputer() {//Exchange ,routingKey. messge
        amqpTemplate.convertAndSend("myOrder","computer","2222S");
    }

    public void sendFruit() {
        amqpTemplate.convertAndSend("myQueue","date:"+System.currentTimeMillis());
    }
}