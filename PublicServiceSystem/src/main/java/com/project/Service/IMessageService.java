package com.project.Service;

import com.project.entity.MessageEntity;
import com.project.entity.PageEntity;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 消息业务层接口
 */

public interface IMessageService {
    /**
     * 通过用户id查询消息集合
     * @param userId 用户名
     * @return 消息集合
     */
    public PageEntity<MessageEntity> findMessageListByUserName(int userId,int pageNum,int pageSize);

    /**
     * 删除消息，通过id查询消息并修改消息的类型为不可见
     * @param messageId 消息id
     */
    public void deleteMessageTypeById(int messageId);

    /**
     * 阅读消息，查询消息并修改消息的类型为已读
     * @param messageId 消息id
     */
    public MessageEntity readMessageById(int messageId);

    /**
     * 添加消息
     * @param messageEntity 消息实体
     */
    public void addMessage(MessageEntity messageEntity);

}
