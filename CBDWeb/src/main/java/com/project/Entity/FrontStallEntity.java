package com.project.Entity;

import javax.persistence.*;

/**
 * 车位信息实体
 */

/**
 * 车位信息表
 */
public class FrontStallEntity {
    /**
     * id
     */

    private int id;
    /**
     * 车位编号
     */

    private  String stallNum;
    /**
     * 车位地址
     */

    private String stallAddress;
    /**
     * 车位状态
     */

    private int stallState;
    /**
     * 车位产权
     */

    private String stallPhoto;
    /**
     * 车位小区编号
     */

    private String stallAreaNum;
    /**
     * 车位所属
     */

    private int stallOwner;
    /**
     * 身份证号码
     */

    private String IDNum;

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
