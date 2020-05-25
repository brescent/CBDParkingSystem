package com.project.util;

import com.project.Entity.MessageEntity;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送工具类
 */
@Component
public  class SendMsgUtil {

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     * @param message 消息实体
     */
    public   void  sendMessage(MessageEntity message){
        amqpTemplate.convertAndSend("message_exchange","message.msg",message);
    }

    /**'
     * 发送对象
     * @param obj
     */
    public   void  sendObj(Object obj){
        amqpTemplate.convertAndSend("message_exchange","obj.obj",obj);
    }

    /**
     * 发送字符串
     * @param str
     */
    public   void  sendStr(String str){
        amqpTemplate.convertAndSend("message_exchange","str.str",str);
    }


}
