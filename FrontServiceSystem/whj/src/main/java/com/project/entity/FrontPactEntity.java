package com.project.entity;

import javax.persistence.*;

/**
 * 合同实体
 */
@Entity
@Table(name = "t_frontPact")
public class FrontPactEntity {

    public FrontPactEntity() {
    }

    public FrontPactEntity(int pactState, com.project.entity.FrontOrderEntity frontOrderId) {
        this.pactState = pactState;
        this.frontOrderId = frontOrderId;
    }

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
     * 订单外键
     */
    @OneToOne
    @JoinColumn(name = "fk_frontOrderId")
    private com.project.entity.FrontOrderEntity frontOrderId;

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

    public com.project.entity.FrontOrderEntity getFrontOrderId() {
        return frontOrderId;
    }

    public void setFrontOrderId(com.project.entity.FrontOrderEntity frontOrderId) {
        this.frontOrderId = frontOrderId;
    }
}

