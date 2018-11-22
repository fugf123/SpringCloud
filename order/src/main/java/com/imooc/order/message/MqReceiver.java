package com.imooc.order.message;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {
   // 1.@RabbitListener(queues = "myQueue")
    //2. 自动创建队列
  //  @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3. 自动创建，Exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myQueue")
    ))
    public void process(String messge) {
        System.out.println(messge);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("orderQueue"),
            exchange = @Exchange("myOrder"),
            key = "computer"
    ))
    public void processComputer(String messge) {
        System.out.println(messge);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitQueue"),
            exchange = @Exchange("myOrder"),
            key = "fruit"
    ))
    public void processFruitComputer(String messge) {
        System.out.println(messge);
    }

}
