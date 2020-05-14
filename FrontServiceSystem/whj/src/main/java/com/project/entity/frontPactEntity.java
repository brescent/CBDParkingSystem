package com.project.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 合同实体
 */
@Entity
@Table(name = "t_frontPact")
@Data
public class frontPactEntity {
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
    private frontOrderEntity frontOrderId;
}

