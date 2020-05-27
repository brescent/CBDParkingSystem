package com.project.dao;

import com.project.entity.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 消息持久层接口
 */
public interface IMessageDao extends CrudRepository<MessageEntity,Integer> {
    /**
     * 通过用户id查询消息集合
     * @param receiverId 用户id
     * @return 消息集合
     */
    @Query(value = "select * from t_message where fk_receiver_id = :receiverId and m_status < 2 ",
    countQuery ="select count(1) from t_message where fk_receiver_id = :receiverId and m_status < 2 " ,nativeQuery = true)
    public Page<MessageEntity> findMessageListByUserName(@Param("receiverId") int receiverId, Pageable pageable);

    /**
     * 通过消息id修改消息类型（0为未读，1为已读，2为已删除）
     * @param messageId 消息id
     * @param status 消息状态
     */
    @Modifying
    @Query("update MessageEntity set messageStatus = :messageStatus where messageId = :messageId ")
    public void updateMessageTypeById(@Param("messageId") int messageId,@Param("messageStatus") int status);

    /**
     * 通过id查询消息
     * @param messageId 消息id
     * @return 消息实体
     */
    @Query("from MessageEntity where messageId = :messageId and messageStatus < 2 ")
    public MessageEntity findById(@Param("messageId") int messageId);

//    /**
//     * 添加消息
//     * @param messageEntity 消息实体
//     */
//    public void addMessage(MessageEntity messageEntity);

}
