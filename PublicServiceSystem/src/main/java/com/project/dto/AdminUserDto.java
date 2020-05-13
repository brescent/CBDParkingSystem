package com.project.dto;

import javax.persistence.Column;
import java.util.List;

public class AdminUserDto {
    private int id;
    private String loginName;
    private String pwd;
    private int jobNum;
    private String realName;
    private List<PowerDto> powerList;

    public AdminUserDto() {
    }

    public AdminUserDto(int id, String loginName, String pwd, int jobNum, String realName, List<PowerDto> powerList) {
        this.id = id;
        this.loginName = loginName;
        this.pwd = pwd;
        this.jobNum = jobNum;
        this.realName = realName;
        this.powerList = powerList;
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

    public List<PowerDto> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<PowerDto> powerList) {
        this.powerList = powerList;
    }
}
