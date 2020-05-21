package com.project.vo;

import javax.persistence.*;
import java.util.List;

/**管理员实体类*/


public class AdminVo {
    /**管理员ID*/

    private Integer id;

    /**管理员工号*/

    private int jobNum;

    /**管理员密码*/
    private String pwd;

    /**管理员真实姓名*/

    private String realName;


    private String phone;


   private int[] powerList;

    public AdminVo() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int[] getPowerList() {
        return powerList;
    }

    public void setPowerList(int[] powerList) {
        this.powerList = powerList;
    }
}
