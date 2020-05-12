package com.project.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 账单实体类
 */
@Entity
@Table(name = "t_bill")
public class BillEntity {
    /**账单id*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_billId")
    private int billId;
    /**交易日期*/
    @Column(name = "b_tradeDate")
    private Date tradeDate;
    /**交易时间*/
    @Column(name = "b_tradeTime")
    private Date tradeTime;
    /**收入*/
    @Column(name = "b_income")
    private Double income;
    /**支出*/
    @Column(name = "b_paid")
    private Double paid;
    /**账单所有人*/
    @ManyToOne
    @JoinColumn(name = "fk_userId")
    private PublicUserEntity user;

    public BillEntity() {
    }

    public BillEntity(Date tradeDate, Date tradeTime, Double income, Double paid, PublicUserEntity user) {
        this.tradeDate = tradeDate;
        this.tradeTime = tradeTime;
        this.income = income;
        this.paid = paid;
        this.user = user;
    }

    public BillEntity(int billId, Date tradeDate, Date tradeTime, Double income, Double paid, PublicUserEntity user) {
        this.billId = billId;
        this.tradeDate = tradeDate;
        this.tradeTime = tradeTime;
        this.income = income;
        this.paid = paid;
        this.user = user;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    public PublicUserEntity getUser() {
        return user;
    }

    public void setUser(PublicUserEntity user) {
        this.user = user;
    }
}
