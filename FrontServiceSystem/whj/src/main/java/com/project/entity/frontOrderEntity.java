package com.project.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 订单实体
 */
@Entity
@Table(name = "t_frontOrder")
@Data
public class frontOrderEntity {
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
    private frontUserInfoEntity frontUserInfoId;
    /**
     * 交易信息外键
     */
    @OneToOne
    @JoinColumn(name = "fk_frontcomplaintId")
    private frontcomplaintEntity frontcomplaintId;
}
