package com.project.entity;

import javax.persistence.*;

/**
 *用户信息实体
 */
@Entity
@Table(name = "t_frontUserInfo")
public class frontUserInfo {
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
    @Column(name = "userProfession",length = 32)
    private String userProfession;
    /**
     * 真实姓名
     */
    @Column(name = "realName",length = 32)
    private String realName;
    /**
     * 用户名
     */
    @Column(name = "userName",length = 32)
    private String userName;
    /**
     * 身份证号
     */
    @Column(name = "IDNum",length = 20)
    private String IDNum;
}
