package com.project.entity;


/**公共用户类*/

public class PublicUserEntity {
    /**用户id*/

    private int id;
    /**用户登录名*/
    private String loginName;
    /**用户密码*/
    private String pwd;
    /**用户类型*/
    private int userType;



    public PublicUserEntity() {
    }

    public PublicUserEntity(String loginName, String  pwd, int userType) {
        this.loginName=loginName;
        this.pwd=pwd;
        this.userType=userType;

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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
