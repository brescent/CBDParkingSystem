package com.project.entity;

/**
 * 订单实体
 */

public class FrontOrderEntity {
    /**
     * id
     */

    private int id;
    /**
     * 订单状态
     */

    private int orderState;
    /**
     * 留言信息
     */

    private String message;
    /**
     * 用户外键
     */

    private FrontUserInfoEntity frontUserInfoId;
    /**
     * 交易信息外键
     */

    private FrontDealEntity frontDealId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FrontUserInfoEntity getFrontUserInfoId() {
        return frontUserInfoId;
    }

    public void setFrontUserInfoId(FrontUserInfoEntity frontUserInfoId) {
        this.frontUserInfoId = frontUserInfoId;
    }

    public FrontDealEntity getFrontcomplaintId() {
        return frontDealId;
    }

    public void setFrontcomplaintId(FrontDealEntity frontcomplaintId) {
        this.frontDealId = frontcomplaintId;
    }

    public FrontOrderEntity() {
    }

    public FrontOrderEntity(int orderState, String message,
                            FrontUserInfoEntity frontUserInfoId, FrontDealEntity frontcomplaintId) {
        this.orderState = orderState;
        this.message = message;
        this.frontUserInfoId = frontUserInfoId;
        this.frontDealId = frontcomplaintId;
    }
}
