package com.project.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 消息实体类
 */

public class MessageVo implements Serializable {
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

    private int receiver;
    /**发送用户*/

    private int sender;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public MessageVo() {
    }

    public MessageVo(String messageInfo, int messageType, int messageStatus, int receiver, int sender) {
        this.messageInfo = messageInfo;
        this.messageType = messageType;
        this.messageStatus = messageStatus;
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

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }
}
