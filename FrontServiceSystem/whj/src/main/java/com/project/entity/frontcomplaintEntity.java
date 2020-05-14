package com.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * 投诉实体
 */
@Entity
@Table(name = "t_frontcomplaint")
@Data
public class frontcomplaintEntity {
    /**
     * id
     */
    @Id
    @Column(name="pk_id",nullable=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    /**
     * 投诉内容
     */
    @Column(name = "f_complaintContant",length = 100)
    private  String complaintContant;
    /**
     * 投诉时间
     */
    @Column(name = "f_complaintTime")
    private Date complaintTime;
    /**
     * 订单外键
     */
    @OneToOne
    @JoinColumn(name = "fk_frontOrderId")
    private frontOrderEntity frontOrderId;

}
