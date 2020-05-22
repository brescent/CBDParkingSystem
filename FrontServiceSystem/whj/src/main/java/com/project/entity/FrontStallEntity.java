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
@Data
public class FrontStallEntity {

    public FrontStallEntity() {
    }

    public FrontStallEntity(String stallNum, String stallAddress, int stallState, String stallPhoto, String stallAreaNum, String IDNum, FrontUserInfoEntity stall) {
        this.stallNum = stallNum;
        this.stallAddress = stallAddress;
        this.stallState = stallState;
        this.stallPhoto = stallPhoto;
        this.stallAreaNum = stallAreaNum;
        this.IDNum = IDNum;
        this.stall = stall;
    }

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
     * 身份证号码
     */
    @Column(name = "f_IDNum",length = 20)
    private String IDNum;
    /**
     *用户信息
     */
    @ManyToOne
    @JoinColumn(name = "fk_userId")
    private FrontUserInfoEntity stall;

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

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public FrontUserInfoEntity getStall() {
        return stall;
    }

    public void setStall(FrontUserInfoEntity stall) {
        this.stall = stall;
    }
}
