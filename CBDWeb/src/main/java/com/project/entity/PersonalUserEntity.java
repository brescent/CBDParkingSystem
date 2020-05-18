package com.project.entity;


import javax.persistence.*;

/**个人用户实体类*/

public class PersonalUserEntity {

    /**个人用户id*/

    private int id;

    /**个人用户id*/
    private String realName;

    /**个人用户职业描述*/
    private String jobInfo;

    /**个人用户邮箱*/
    private String email;

    /**个人用户家庭住址*/

    private String homeAddress;

    /**个人用户身份证号*/

    private String IDCardNum;

    /**个人用户身份证号*/

    private String phone;


    private PublicUserEntity publicUser;

    public PersonalUserEntity() {
    }
    public PersonalUserEntity(String realName,String email,String homeAddress,String phone,String jobInfo,String IDCardNum) {
        this.realName=realName;
        this.email=email;
        this.homeAddress=homeAddress;
        this.IDCardNum=IDCardNum;
        this.phone=phone;
        this.jobInfo=jobInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public PublicUserEntity getPublicUser() {
        return publicUser;
    }

    public void setPublicUser(PublicUserEntity publicUser) {
        this.publicUser = publicUser;
    }
}
