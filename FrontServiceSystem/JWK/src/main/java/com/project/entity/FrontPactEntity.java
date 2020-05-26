package com.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


/**
 * 合同实体
 */
@Entity
@Table(name = "t_frontPact")
public class FrontPactEntity {
    /**
     * id
     */
    @Id
    @Column(name="pk_id",nullable=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    /**
     * 合同状态
     */
    @Column(name = "f_pactState",length = 10)
    private int pactState;

    /**
     * 合同状态
     */
    @Column(name = "f_pactTime")
    private Date pactTime=new Date(System.currentTimeMillis());
    /**
     * 订单外键
     */
    @OneToOne
    @JoinColumn(name = "fk_frontOrderId")
    private FrontOrderEntity frontOrderId;

    public FrontPactEntity() {
    }

    public FrontPactEntity(int pactState, FrontOrderEntity frontOrderId) {
        this.pactState = pactState;
        this.frontOrderId = frontOrderId;
    }

    public Date getPactTime() {
        return pactTime;
    }

    public void setPactTime(Date pactTime) {
        this.pactTime = pactTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPactState() {
        return pactState;
    }

    public void setPactState(int pactState) {
        this.pactState = pactState;
    }

    public FrontOrderEntity getFrontOrderId() {
        return frontOrderId;
    }

    public void setFrontOrderId(FrontOrderEntity frontOrderId) {
        this.frontOrderId = frontOrderId;
    }
}

