package com.project.Service.impl;

import com.project.Service.IMessageService;
import com.project.dao.IMessageDao;
import com.project.entity.MessageEntity;
import com.project.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageDao dao;

    @Override
    public PageEntity<MessageEntity> findMessageListByUserName(int userId,int pageNum,int pageSize) {
        PageEntity<MessageEntity> pageEntity = new PageEntity<MessageEntity>();
        Pageable pageable = PageRequest.of(pageNum-1,pageSize,new Sort(Sort.Direction.ASC,"pk_message_id"));
        Page<MessageEntity> page = dao.findMessageListByUserName(userId,pageable);
        pageEntity.setList(page.getContent());
        pageEntity.setCount((int) page.getTotalElements());
        pageEntity.setPageSize(pageSize);
        pageEntity.setPageNum(pageNum);

        return pageEntity;
    }

    @Override
    public void deleteMessageTypeById(int messageId) {
        dao.updateMessageTypeById(messageId,2);
    }

    @Override
    public MessageEntity readMessageById(int messageId) {
        dao.updateMessageTypeById(messageId,1);
        return dao.findById(messageId);
    }

    @Override
    public void addMessage(MessageEntity messageEntity) {
        dao.save(messageEntity);
    }

}
