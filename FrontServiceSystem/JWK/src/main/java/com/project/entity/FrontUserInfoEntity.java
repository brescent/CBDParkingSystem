package com.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 *用户信息实体
 */
@Entity
@Table(name = "t_frontUserInfo")
public class FrontUserInfoEntity {
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
    @OneToMany(mappedBy = "userInfoEntity" ,fetch = FetchType.LAZY)
    private List<FrontStallEntity> frontStallEntity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserProfession() {
        return userProfession;
    }

    public void setUserProfession(String userProfession) {
        this.userProfession = userProfession;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public List<FrontStallEntity> getFrontStallEntity() {
        return frontStallEntity;
    }

    public void setFrontStallEntity(List<FrontStallEntity> frontStallEntity) {
        this.frontStallEntity = frontStallEntity;
    }

    public FrontUserInfoEntity(String userProfession, String realName, String userName, String IDNum, List<FrontStallEntity> frontStallEntity) {
        this.userProfession = userProfession;
        this.realName = realName;
        this.userName = userName;
        this.IDNum = IDNum;
        this.frontStallEntity = frontStallEntity;
    }

    public FrontUserInfoEntity() {
    }
}
