package com.imooc.order.message;

import com.imooc.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.junit.Assert.*;

@Component
public class StreamReceiverTest extends OrderApplicationTests{

    @Autowired
    private StreamClient streamClient;
    @Test
    public void process() throws Exception {
        Message message = MessageBuilder.withPayload("now"+new Date()).build();//获得发送信息的Message
        streamClient.output().send(message); //调用发送方法发送消息


    }

}