package com.project.entity;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 账单实体类
 */

public class BillEntity {
    /**账单id*/

    private int billId;
    /**交易日期*/

    private Date tradeDate=new Date(System.currentTimeMillis());
    /**交易时间*/

    private Date tradeTime=new Date(System.currentTimeMillis());
    /**收入*/

    private Double income;
    /**支出*/

    private Double paid;
    /**交易备注*/
    private String billInfo;
    /**账单所有人*/

    private PublicUserEntity user;

    public BillEntity() {
    }

    public BillEntity(Date tradeDate, Date tradeTime, Double income, Double paid, PublicUserEntity user, String billInfo) {
        this.tradeDate = tradeDate;
        this.tradeTime = tradeTime;
        this.income = income;
        this.paid = paid;
        this.user = user;
        this.billInfo = billInfo;
    }

    public BillEntity(int billId, Date tradeDate, Date tradeTime, Double income, Double paid, PublicUserEntity user, String billInfo) {
        this.billId = billId;
        this.tradeDate = tradeDate;
        this.tradeTime = tradeTime;
        this.income = income;
        this.paid = paid;
        this.user = user;
        this.billInfo = billInfo;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getTradeDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tradeDateStr = sdf.format(tradeDate);
        return tradeDateStr;
    }

    public String getTradeTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String tradeTimeStr = sdf.format(tradeTime);
        return tradeTimeStr;
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

    public String getBillInfo() {
        return billInfo;
    }

    public void setBillInfo(String billInfo) {
        this.billInfo = billInfo;
    }
}
