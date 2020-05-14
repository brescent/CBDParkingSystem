package com.project.dto;

public class MessageDto {
    String messageInfo;
    int messageType;
    String receiverName;
    String senderName;

    public MessageDto() {
    }

    public MessageDto(String messageInfo, int messageType, String receiverName, String senderName) {
        this.messageInfo = messageInfo;
        this.messageType = messageType;
        this.receiverName = receiverName;
        this.senderName = senderName;
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

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
}
