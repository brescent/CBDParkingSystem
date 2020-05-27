package com.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.project.dto.UserDto;
import com.project.entity.MessageEntity;
import com.project.entity.PageEntity;
import com.project.entity.PublicUserEntity;
import com.project.service.IPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MessageController {

    @Autowired
    IPublicService publicService;

    @GetMapping("showMessageList")
    public String findMessageList(HttpServletRequest request, Integer pageNum, Integer pageSize){
        String messageJson = null;
        UserDto user = (UserDto) request.getSession().getAttribute("user");
        String userName = user.getLoginName();
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        PageEntity<MessageEntity> page = publicService.findMessageList(userName,pageNum,pageSize);
        messageJson = JSON.toJSONString(page, SerializerFeature.WriteDateUseDateFormat);
        return messageJson;
    }

    /**
     * 查看消息并改变消息状态为已读
     * @param messageId 消息id
     * @return 消息实体
     */
    @RequestMapping("readMessage")
    public String readMessage(Integer messageId){
        String messageJson = null;
        MessageEntity messageEntity = publicService.readMessage(messageId);
        messageJson = JSON.toJSONString(messageEntity);
        return messageJson;
    }

    @RequestMapping("deleteMessage")
    public void deleteMessage(Integer messageId){
        publicService.deleteMessage(messageId);
    }
}
