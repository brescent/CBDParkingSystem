package com.project.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 投诉实体
 */
@Entity
@Table(name = "t_frontcomplaint")
public class FrontComplaintEntity {

    public FrontComplaintEntity() {
    }

    public FrontComplaintEntity(String complaintContant, Date complaintTime, com.project.entity.FrontOrderEntity frontOrderId) {
        this.complaintContant = complaintContant;
        this.complaintTime = complaintTime;
        this.frontOrderId = frontOrderId;
    }

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
    private com.project.entity.FrontOrderEntity frontOrderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComplaintContant() {
        return complaintContant;
    }

    public void setComplaintContant(String complaintContant) {
        this.complaintContant = complaintContant;
    }

    public Date getComplaintTime() {
        return complaintTime;
    }

    public void setComplaintTime(Date complaintTime) {
        this.complaintTime = complaintTime;
    }

    public com.project.entity.FrontOrderEntity getFrontOrderId() {
        return frontOrderId;
    }

    public void setFrontOrderId(com.project.entity.FrontOrderEntity frontOrderId) {
        this.frontOrderId = frontOrderId;
    }
}
