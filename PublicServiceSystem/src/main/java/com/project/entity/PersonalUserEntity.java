package com.project.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**个人用户实体类*/
@Entity
@Table(name = "t_personalUser")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@DynamicInsert
@DynamicUpdate
public class PersonalUserEntity {

    /**个人用户id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_personalUserID")
    private int id;

    /**个人用户id*/
    @Column(name = "p_realName")
    private String realName;

    /**个人用户职业描述*/
    @Column(name = "p_jobInfo")
    private String jobInfo;

    /**个人用户邮箱*/
    @Column(name = "p_email")
    private String email;

    /**个人用户家庭住址*/
    @Column(name = "p_homeAddress")
    private String homeAddress;

    /**个人用户身份证号*/
    @Column(name = "p_IDCardNum")
    private String IDCardNum;

    /**个人用户身份证号*/
    @Column(name = "p_phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_publicUserId",referencedColumnName = "pk_publicUserId",nullable = false)
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
