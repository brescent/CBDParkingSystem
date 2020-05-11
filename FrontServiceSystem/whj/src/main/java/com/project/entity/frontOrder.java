package com.project.entity;

import javax.persistence.*;

/**
 * 订单实体
 */
@Entity
@Table(name = "t_frontOrder")
public class frontOrder {
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
    @Column(name = "orderState",length = 8)
    private int orderState;
    /**
     * 留言信息
     */
    @Column(name = "message",length = 100)
    private String message;
}
