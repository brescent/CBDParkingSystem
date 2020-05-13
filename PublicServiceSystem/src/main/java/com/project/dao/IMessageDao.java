package com.project.dao;

import com.project.entity.MessageEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 消息持久层接口
 */
@Repository
public interface IMessageDao {
    /**
     * 通过用户id查询消息集合
     * @param userId 用户id
     * @return 消息集合
     */
    public List<MessageEntity> findMessageListByUserId(int userId);

    /**
     * 通过消息id修改消息类型（0为未读，1为已读，2为已删除）
     * @param messageId 消息id
     * @param type 消息类型
     */
    public void updateMessageTypeById(int messageId,int type);

    /**
     * 通过id查询消息
     * @param messageId 消息id
     * @return 消息实体
     */
    public MessageEntity findById(int messageId);

}
