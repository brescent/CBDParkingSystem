package com.project.util;

import com.project.Service.IMessageService;
import com.project.entity.MessageEntity;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.util.Map;

@Component
public class ReceiveMsgUtil {

    @Autowired
    IMessageService messageService;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value ="message_queue",autoDelete = "false",durable = "false",exclusive = "false",declare = "true"),
                    exchange = @Exchange(value = "message_exchange",type = "topic",durable = "true"),
                    key = "message.#"
            )
    )
    @RabbitHandler//标注消费者端用于处理队列的方法
    public void getMsg(@Payload MessageEntity message , Channel channel , @Headers Map headers){

        //手动确认

       Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(tag,false);
            messageService.addMessage(message);
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value ="object_queue",autoDelete = "false",durable = "false",exclusive = "false",declare = "true"),
                    exchange = @Exchange(value = "message_exchange",type = "topic",durable = "true"),
                    key = "obj.#"
            )
    )
    @RabbitHandler//标注消费者端用于处理队列的方法
    public Object getObj(@Payload Object dataObj , Channel channel , @Headers Map headers){



        //手动确认
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(tag,false);
            return dataObj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value ="string_queue",autoDelete = "false",durable = "false",exclusive = "false",declare = "true"),
                    exchange = @Exchange(value = "message_exchange",type = "topic",durable = "true"),
                    key = "str.#"
            )
    )
    @RabbitHandler//标注消费者端用于处理队列的方法
    public String getStr(@Payload String str , Channel channel , @Headers Map headers){
        //手动确认
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(tag,false);
            return str;
        } catch (IOException e) {

            e.printStackTrace();
            return  null;
        }


    }
}
