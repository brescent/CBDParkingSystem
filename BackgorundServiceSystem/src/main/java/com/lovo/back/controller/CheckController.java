package com.lovo.back.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 个人用户审核控制器
 */
@Service
public class CheckController {


    @Autowired
    private RabbitTemplate amqpTemplate;
    /**
     * 修改合同审核审核状态
     * @param partId
     * @return
     */
    @GetMapping("updPartCheckType/{partId}")
    @ResponseBody
    public String updPartCheckType(@PathVariable("partId") Integer partId){


       amqpTemplate.convertAndSend("message_exchange","message.aaa","用户你的合同已经通过审核");
        return "1";

    }
}
