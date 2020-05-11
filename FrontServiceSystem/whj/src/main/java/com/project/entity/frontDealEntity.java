package com.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * 交易信息实体
 */
@Entity
@Data
@Table(name = "t_frontDeal")
public class frontDealEntity {
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
    @Column(name = "dealPrice",length = 32)
    private float dealPrice;
    /**
     * 交易开始时间
     */
    @Column(name = "dealStartDate")
    private Date dealStartDate;
    /**
     * 交易结束时间
     */
    @Column(name = "dealEndDate")
    private Date dealEndDate;
    /**
     * 交易状态
     */
    @Column(name = "dealState",length = 32)
    private int dealState;
    /**
     * 交易时间
     */
    @Column(name = "dealTime")
    private Date dealTime;
    /**
     *交易类型
     */
    @Column(name = "dealType",length = 32)
    private int dealType;

}
