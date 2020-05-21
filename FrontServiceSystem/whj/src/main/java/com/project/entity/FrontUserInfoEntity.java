package com.project.entity;

import javax.persistence.*;
import java.util.Set;

/**
 *用户信息实体
 */
@Entity
@Table(name = "t_frontUserInfo")
public class FrontUserInfoEntity {

    public FrontUserInfoEntity() {
    }

    public FrontUserInfoEntity(String userProfession, String realName, String userName, String IDNum, Set<FrontStallEntity> frontStallEntities) {
        this.userProfession = userProfession;
        this.realName = realName;
        this.userName = userName;
        this.IDNum = IDNum;
        this.frontStallEntities = frontStallEntities;
    }

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
    /**
     *
     * 车位信息
     */
    @OneToMany(mappedBy = "stall")
    private Set<FrontStallEntity> frontStallEntities;

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

    public Set<FrontStallEntity> getFrontStallEntities() {
        return frontStallEntities;
    }

    public void setFrontStallEntities(Set<FrontStallEntity> frontStallEntities) {
        this.frontStallEntities = frontStallEntities;
    }
}
