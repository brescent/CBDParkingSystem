package com.lovo.back.dto;

import com.lovo.back.entity.CompanyContractAndStall;


import java.sql.Date;
import java.util.Set;

public class CompanyContractDto {



    /*企业合同主键 唯一标志*/

    private int id;
    /*企业合同编号*/

    private String contractNo;
    /*合同生效时期*/

    private Date startDate;
    /*合同失效时间*/

    private Date endDate;
    /*合同成交价格*/

    private double dealPrice;

    /*合同图片名称*/

    private String contractImg;
    /*旧合同编号  可为空为续约合同  准备*/

    private String oldContractNo;

    /*企业 对象*/

    private String companyName;

    private CompanyDto company;

    private Set<CompanyContractAndStall> set;
    /*车位*/

    /*合同生效状态*/
    private int state=1;

    public CompanyContractDto() {
    }

    public CompanyContractDto(String contractNo, Date startDate, Date endDate, double dealPrice, String contractImg, String oldContractNo) {
        this.contractNo = contractNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealPrice = dealPrice;
        this.contractImg = contractImg;
        this.oldContractNo = oldContractNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getContractImg() {
        return contractImg;
    }

    public void setContractImg(String contractImg) {
        this.contractImg = contractImg;
    }

    public String getOldContractNo() {
        return oldContractNo;
    }

    public void setOldContractNo(String oldContractNo) {
        this.oldContractNo = oldContractNo;
    }

//    public void setCompany(CompanyEntity company) {
//        this.company = company;
//    }


    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Set<CompanyContractAndStall> getSet() {
        return set;
    }

    public void setSet(Set<CompanyContractAndStall> set) {
        this.set = set;
    }
}
