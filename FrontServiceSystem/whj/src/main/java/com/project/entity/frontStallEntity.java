package com.project.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

/**
 * 车位信息实体
 */
import lombok.Data;

import javax.persistence.*;

/**
 * 车位信息表
 */
@Entity
@Table(name = "t_frontStall")
@Data
public class frontStallEntity {
    /**
     * id
     */
    @Id
    @Column(name="pk_id",nullable=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    /**
     * 车位编号
     */
    @Column(name = "f_stallNum",length = 32)
    private  String stallNum;
    /**
     * 车位地址
     */
    @Column(name = "f_stallAddress",length = 50)
    private String stallAddress;
    /**
     * 车位状态
     */
    @Column(name = "f_stallState",length = 32)
    private String stallState;
    /**
     * 车位产权
     */
    @Column(name = "f_stallPhoto",length = 100)
    private String stallPhoto;
    /**
     * 车位小区编号
     */
    @Column(name = "f_stallAreaNum",length = 32)
    private String stallAreaNum;
    /**
     * 车位所属
     */
    @Column(name = "f_stallOwner",length = 32)
    private int stallOwner;
    /**
     * 身份证号码
     */
    @Column(name = "f_IDNum",length = 20)
    private String IDNum;
}
