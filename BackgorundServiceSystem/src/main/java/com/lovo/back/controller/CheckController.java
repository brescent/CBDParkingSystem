package com.lovo.back.controller;

import com.lovo.back.entity.MessageEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个人用户审核控制器
 */

@RestController
public class CheckController {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public  String updPartType(@PathVariable("partId") Integer partId){
        MessageEntity messageEntity =
                new MessageEntity("合同审核通过",1,1,1,1);

        amqpTemplate.convertAndSend("message_exchange","message_all",messageEntity);
        return "1";
    }

}
