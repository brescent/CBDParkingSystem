package com.project.Service;

import com.project.entity.MessageEntity;

import java.util.List;

/**
 * 消息业务层接口
 */
public interface IMessageService {
    /**
     * 通过用户id查询消息集合
     * @param userId 用户id
     * @return 消息集合
     */
    public List<MessageEntity> findMessageListByUserId(int userId);

    /**
     * 删除消息，通过id查询消息并修改消息的类型为不可见
     * @param messageId 消息id
     */
    public void deleteMessageTypeById(int messageId);

    /**
     * 阅读消息，查询消息并修改消息的类型为已读
     * @param messageId 消息id
     */
    public void readMessageById(int messageId);
}
