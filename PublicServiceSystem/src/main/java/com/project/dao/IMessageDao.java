package com.project.dao;

import com.project.entity.MessageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 消息持久层接口
 */
@Repository
public interface IMessageDao extends CrudRepository<MessageEntity,Integer> {
    /**
     * 通过用户id查询消息集合
     * @param userName 用户名
     * @return 消息集合
     */
    @Query("from MessageEntity where receiver.name = :userName")
    public List<MessageEntity> findMessageListByUserId(@Param("userName") String userName);

    /**
     * 通过消息id修改消息类型（0为未读，1为已读，2为已删除）
     * @param messageId 消息id
     * @param type 消息类型
     */
    @Query("update MessageEntity set messageType = :messageType where messageId = :messageId")
    public void updateMessageTypeById(@Param("messageId") int messageId,@Param("messageType") int type);

    /**
     * 通过id查询消息
     * @param messageId 消息id
     * @return 消息实体
     */
    @Query("from MessageEntity where messageId = :messageId")
    public MessageEntity findById(@Param("messageId") int messageId);

//    /**
//     * 添加消息
//     * @param messageEntity 消息实体
//     */
//    public void addMessage(MessageEntity messageEntity);

}
