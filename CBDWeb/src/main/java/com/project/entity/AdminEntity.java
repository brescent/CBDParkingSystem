package com.project.Entity;



import com.project.entity.PowerEntity;
import com.project.entity.PublicUserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**管理员实体类*/


public class AdminEntity implements Serializable {
    /**管理员ID*/

    private Integer id;

    /**管理员工号*/

    private int jobNum;

    /**管理员真实姓名*/

    private String realName;


    private String phone;


    private PublicUserEntity publicUser;



    private List<PowerEntity> powerList;

    public AdminEntity() {
    }

    public AdminEntity(int jobNum, String realName, String phone) {
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
