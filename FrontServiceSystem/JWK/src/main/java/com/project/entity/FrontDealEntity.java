package com.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * 交易信息实体
 */
@Entity
@Table(name = "t_frontDeal")
public class FrontDealEntity {


    /**
     * id
     */
    @Id
    @Column(name="pk_id",nullable=true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    /**
     * 交易价格
     */
    @Column(name = "f_dealPrice",length = 32)
    private float dealPrice;
    /**
     * 交易开始时间
     */
    @Column(name = "f_dealStartDate")
    private Date dealStartDate;
    /**
     * 交易结束时间
     */
    @Column(name = "f_dealEndDate")
    private Date dealEndDate;
    /**
     * 0为审核中，1为交易中 2失效 3为审核失败
     */
    @Column(name = "f_dealState",length = 32)
    private int dealState;
    /**
     * 交易时间
     */
    @Column(name = "f_dealTime")
    private Date dealTime=new Date(System.currentTimeMillis());
    /**
     *交易类型
     * 0为出租，1出售，
     */
    @Column(name = "f_dealType",length = 32)
    private int dealType;
    /**
     * 车位外键
     */
    @OneToOne
    @JoinColumn(name = "fk_frontStallId")
    private FrontStallEntity frontStallId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(float dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Date getDealStartDate() {
        return dealStartDate;
    }

    public void setDealStartDate(Date dealStartDate) {
        this.dealStartDate = dealStartDate;
    }

    public Date getDealEndDate() {
        return dealEndDate;
    }

    public void setDealEndDate(Date dealEndDate) {
        this.dealEndDate = dealEndDate;
    }

    public int getDealState() {
        return dealState;
    }

    public void setDealState(int dealState) {
        this.dealState = dealState;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public int getDealType() {
        return dealType;
    }

    public void setDealType(int dealType) {
        this.dealType = dealType;
    }

    public FrontStallEntity getFrontStallId() {
        return frontStallId;
    }

    public void setFrontStallId(FrontStallEntity frontStallId) {
        this.frontStallId = frontStallId;
    }

    public FrontDealEntity() {
    }

    public FrontDealEntity(float dealPrice, Date dealStartDate, Date dealEndDate,
                           int dealState, Date dealTime, int dealType, FrontStallEntity frontStallId) {
        this.dealPrice = dealPrice;
        this.dealStartDate = dealStartDate;
        this.dealEndDate = dealEndDate;
        this.dealState = dealState;
        this.dealTime = dealTime;
        this.dealType = dealType;
        this.frontStallId = frontStallId;
    }
}
