package com.project.Entity;

import com.project.entity.PublicUserEntity;


import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 消息实体类
 */

public class MessageEntity {
    /**消息id*/

    private int messageId;
    /**消息内容*/

    private String messageInfo;
    /**消息类型 0是个人消息，1是系统消息*/

    private int messageType;
    /**消息发送日期*/

    private Date messageDate = new Date(System.currentTimeMillis());
    /**消息状态 0表示未读，1表示已读，2表示已删除*/

    private int messageStatus = 0;
    /**接收用户*/

    private com.project.entity.PublicUserEntity receiver;
    /**发送用户*/

    private com.project.entity.PublicUserEntity sender;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public MessageEntity() {
    }

    public MessageEntity(String messageInfo, int messageType, Date messageDate, int messageStatus, com.project.entity.PublicUserEntity receiver, com.project.entity.PublicUserEntity sender) {
        this.messageInfo = messageInfo;
        this.messageType = messageType;
        this.messageDate = messageDate;
        this.messageStatus = messageStatus;
        this.receiver = receiver;
        this.sender = sender;
    }

    public MessageEntity(String messageInfo, int messageType, com.project.entity.PublicUserEntity receiver, com.project.entity.PublicUserEntity sender) {
        this.messageInfo = messageInfo;
        this.messageType = messageType;
        this.receiver = receiver;
        this.sender = sender;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getMessageDate() {
        return sdf.format(messageDate);
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    public com.project.entity.PublicUserEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(com.project.entity.PublicUserEntity receiver) {
        this.receiver = receiver;
    }

    public com.project.entity.PublicUserEntity getSender() {
        return sender;
    }

    public void setSender(PublicUserEntity sender) {
        this.sender = sender;
    }
}
