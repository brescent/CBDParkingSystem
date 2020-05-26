package com.project.controller;

import com.project.Service.IMessageService;
import com.project.Service.IUserService;
import com.project.dto.MessageDto;
import com.project.entity.MessageEntity;
import com.project.entity.PublicUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息控制层
 */
@RestController
@RequestMapping("message")
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
    @GetMapping("find/{userName}")
    public List<MessageEntity> findMessageListByUserId(@PathVariable("userName") String userName){
        List<MessageEntity> messageList = new ArrayList<MessageEntity>();
        messageList = messageService.findMessageListByUserName(userName);
        return messageList;
    }

    /**
     * 查看消息并改变消息状态为已读
     * @param messageId 消息id
     * @return 消息实体
     */
    @PutMapping("read/{messageId}")
    public MessageEntity readMessage(@PathVariable("messageId")int messageId){
        MessageEntity messageEntity = messageService.findById(messageId);
        messageService.readMessageById(messageId);
        return messageEntity;
    }

}
