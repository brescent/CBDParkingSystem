package com.project.dto;


import java.util.List;

/**
 * 登录dto
 */
public class UserDto {
    private int id;
    private String loginName;
    private String pwd;
    private List<PowerDto> powerList;
    private String userType;


    public UserDto() {

    }

    public UserDto(int id, String loginName, String pwd, List<PowerDto> powerList) {
        this.id = id;
        this.loginName = loginName;
        this.pwd = pwd;
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

    public List<PowerDto> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<PowerDto> powerList) {
        this.powerList = powerList;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
