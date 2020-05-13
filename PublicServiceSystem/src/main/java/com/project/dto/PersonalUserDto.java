package com.project.dto;

import javax.persistence.Column;

public class PersonalUserDto {
    private int id;
    private String loginName;
    private String pwd;
    private String realName;
    private String jobInfo;
    private String email;
    private String homeAddress;
    private String IDCardNum;
    private String phone;

    public PersonalUserDto() {
    }

    public PersonalUserDto(int id, String loginName, String pwd, String realName, String jobInfo, String email, String homeAddress, String IDCardNum, String phone) {
        this.id = id;
        this.loginName = loginName;
        this.pwd = pwd;
        this.realName = realName;
        this.jobInfo = jobInfo;
        this.email = email;
        this.homeAddress = homeAddress;
        this.IDCardNum = IDCardNum;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getIDCardNum() {
        return IDCardNum;
    }

    public void setIDCardNum(String IDCardNum) {
        this.IDCardNum = IDCardNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
