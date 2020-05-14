package com.project.Service.impl;

import com.project.Service.IMessageService;
import com.project.dao.IMessageDao;
import com.project.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageDao dao;

    @Override
    public List<MessageEntity> findMessageListByUserName(String userName) {
        return dao.findMessageListByUserId(userName);
    }

    @Override
    public void deleteMessageTypeById(int messageId) {
        dao.updateMessageTypeById(messageId,2);
    }

    @Override
    public void readMessageById(int messageId) {
        dao.updateMessageTypeById(messageId,1);
    }

    @Override
    public void addMessage(MessageEntity messageEntity) {
        dao.save(messageEntity);
    }

    @Override
    public MessageEntity findById(int messageId) {
        return dao.findById(messageId);
    }
}
