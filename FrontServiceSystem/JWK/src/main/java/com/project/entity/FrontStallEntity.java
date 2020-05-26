package com.project.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 车位信息实体
 */

/**
 * 车位信息表
 */
@Entity
@Table(name = "t_frontStall")
public class FrontStallEntity {
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
    private int stallState;
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
    @ManyToOne
    @JoinColumn(name = "fk_frontUserId")
    private  FrontUserInfoEntity userInfoEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStallNum() {
        return stallNum;
    }

    public void setStallNum(String stallNum) {
        this.stallNum = stallNum;
    }

    public String getStallAddress() {
        return stallAddress;
    }

    public void setStallAddress(String stallAddress) {
        this.stallAddress = stallAddress;
    }

    public int getStallState() {
        return stallState;
    }

    public void setStallState(int stallState) {
        this.stallState = stallState;
    }

    public String getStallPhoto() {
        return stallPhoto;
    }

    public void setStallPhoto(String stallPhoto) {
        this.stallPhoto = stallPhoto;
    }

    public String getStallAreaNum() {
        return stallAreaNum;
    }

    public void setStallAreaNum(String stallAreaNum) {
        this.stallAreaNum = stallAreaNum;
    }

    public int getStallOwner() {
        return stallOwner;
    }

    public void setStallOwner(int stallOwner) {
        this.stallOwner = stallOwner;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public FrontUserInfoEntity getUserInfoEntity() {
        return userInfoEntity;
    }

    public void setUserInfoEntity(FrontUserInfoEntity userInfoEntity) {
        this.userInfoEntity = userInfoEntity;
    }

    public FrontStallEntity() {
    }

    public FrontStallEntity(String stallNum, String stallAddress, int stallState,
                            String stallPhoto, String stallAreaNum, int stallOwner,
                            String IDNum, FrontUserInfoEntity userInfoEntity) {
        this.stallNum = stallNum;
        this.stallAddress = stallAddress;
        this.stallState = stallState;
        this.stallPhoto = stallPhoto;
        this.stallAreaNum = stallAreaNum;
        this.stallOwner = stallOwner;
        this.IDNum = IDNum;
        this.userInfoEntity = userInfoEntity;
    }

}
