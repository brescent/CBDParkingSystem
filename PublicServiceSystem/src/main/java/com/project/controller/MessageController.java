package com.project.controller;

import com.project.Service.IMessageService;
import com.project.Service.IUserService;
import com.project.dto.MessageDto;
import com.project.entity.MessageEntity;
import com.project.entity.PageEntity;
import com.project.entity.PublicUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息控制层
 */
@RestController
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    /**
     * 添加消息
     * @param messageDto 消息Dto
     */
    @PostMapping("addMessage")
    public void addMessage(MessageDto messageDto){
        PublicUserEntity receiver = userService.findUserByName(messageDto.getReceiverName());
        PublicUserEntity sender = userService.findUserByName(messageDto.getSenderName());
        MessageEntity messageEntity = new MessageEntity(messageDto.getMessageInfo(),messageDto.getMessageType(),receiver,sender);
        messageService.addMessage(messageEntity);
    }

    /**
     * 通过用户id查询某用户的消息集合
     * @param userName 用户名
     * @return 消息集合
     */
    @GetMapping("findMessageList")
    public PageEntity<MessageEntity> findMessageListByUserId(String userName, int pageNum, int pageSize){
        PageEntity<MessageEntity> pageEntity = new PageEntity<>();
        PublicUserEntity userEntity = userService.findUserByName(userName);
        pageEntity = messageService.findMessageListByUserName(userEntity.getId(),pageNum,pageSize);
        return pageEntity;
    }

    /**
     * 查看消息并改变消息状态为已读
     * @param messageId 消息id
     * @return 消息实体
     */
    @RequestMapping("readMessage")
    public MessageEntity readMessage(int messageId){
        MessageEntity messageEntity = messageService.readMessageById(messageId);
        return messageEntity;
    }

    @RequestMapping("deleteMessage")
    public void deleteMessage(int messageId){
        messageService.deleteMessageTypeById(messageId);
    }

}
