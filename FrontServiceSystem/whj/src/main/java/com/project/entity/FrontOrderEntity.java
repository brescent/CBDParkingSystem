package com.project.entity;

import javax.persistence.*;

/**
 * 订单实体
 */
@Entity
@Table(name = "t_frontOrder")
public class FrontOrderEntity {

    public FrontOrderEntity() {
    }

    public FrontOrderEntity(int orderState, String message, FrontUserInfoEntity frontUserInfoId, com.project.entity.FrontDealEntity frontDealEntity) {
        this.orderState = orderState;
        this.message = message;
        this.frontUserInfoId = frontUserInfoId;
        this.frontDealEntity = frontDealEntity;
    }

    /**
     * id
     */
    @Id
    @Column(name="pk_id",nullable=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    /**
     * 订单状态
     */
    @Column(name = "f_orderState",length = 8)
    private int orderState;
    /**
     * 留言信息
     */
    @Column(name = "f_message",length = 100)
    private String message;
    /**
     * 用户外键
     */
    @OneToOne
    @JoinColumn(name = "fk_frontUserInfoId")
    private FrontUserInfoEntity frontUserInfoId;
    /**
     * 交易信息外键
     */
    @OneToOne
    @JoinColumn(name = "fk_DealId")
    private com.project.entity.FrontDealEntity frontDealEntity;

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

    public com.project.entity.FrontDealEntity getFrontDealEntity() {
        return frontDealEntity;
    }

    public void setFrontDealEntity(com.project.entity.FrontDealEntity frontDealEntity) {
        this.frontDealEntity = frontDealEntity;
    }
}
