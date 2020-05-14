package com.project.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *用户信息实体
 */
@Entity
@Table(name = "t_frontUserInfo")
@Data
public class frontUserInfoEntity {
    /**
     * id
     */
    @Id
    @Column(name="pk_id",nullable=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    /**
     * 职业
     */
    @Column(name = "f_userProfession",length = 32)
    private String userProfession;
    /**
     * 真实姓名
     */
    @Column(name = "f_realName",length = 32)
    private String realName;
    /**
     * 用户名
     */
    @Column(name = "f_userName",length = 32)
    private String userName;
    /**
     * 身份证号
     */
    @Column(name = "f_IDNum",length = 20)
    private String IDNum;
}
