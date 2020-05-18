package com.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**管理员实体类*/

@Entity
@Table(name = "t_admin")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class AdminEntity implements Serializable {
    /**管理员ID*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_adminId")
    private Integer id;

    /**管理员工号*/
    @Column(name = "a_jobNum")
    private int jobNum;

    /**管理员真实姓名*/
    @Column(name = "a_realName")
    private String realName;

    @Column(name = "a_phone")
    private String phone;

    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_publicUserId",referencedColumnName = "pk_publicUserId",nullable = false)
    private PublicUserEntity publicUser;

    @OneToMany(mappedBy = "admin")
    private List<PowerEntity> powerList;

    public AdminEntity() {
    }

    public AdminEntity(int jobNum,String realName,String phone) {
        this.realName=realName;
        this.jobNum=jobNum;
        this.phone=phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getJobNum() {
        return jobNum;
    }

    public void setJobNum(int jobNum) {
        this.jobNum = jobNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public List<PowerEntity> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<PowerEntity> powerList) {
        this.powerList = powerList;
    }
}
