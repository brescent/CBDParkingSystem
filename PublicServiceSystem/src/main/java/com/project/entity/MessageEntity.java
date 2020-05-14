package com.project.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 消息实体类
 */
@Entity
@Table(name = "t_message")
public class MessageEntity {
    /**消息id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_messageId")
    private int messageId;
    /**消息内容*/
    @Column(name = "m_info")
    private String messageInfo;
    /**消息类型*/
    @Column(name = "m_type")
    private String messageType;
    /**消息发送日期*/
    @Column(name = "m_date")
    private Date messageDate;
    /**消息状态*/
    @Column(name = "m_status")
    private int messageStatus;
    /**接收用户*/
    @OneToOne
    @JoinColumn(name = "fk_receiverId")
    private PublicUserEntity receiver;
    /**发送用户*/
    @OneToOne
    @JoinColumn(name = "fk_senderId")
    private PublicUserEntity sender;

    public MessageEntity() {
    }

    public MessageEntity(String messageInfo, String messageType, Date messageDate, int messageStatus, PublicUserEntity receiver, PublicUserEntity sender) {
        this.messageInfo = messageInfo;
        this.messageType = messageType;
        this.messageDate = messageDate;
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

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    public PublicUserEntity getReceiver() {
        return receiver;
    }

    public void setReceiver(PublicUserEntity receiver) {
        this.receiver = receiver;
    }

    public PublicUserEntity getSender() {
        return sender;
    }

    public void setSender(PublicUserEntity sender) {
        this.sender = sender;
    }
}
