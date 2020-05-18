package com.project.entity;


import lombok.Data;

import javax.persistence.*;

/**公共用户类*/

@Data
public class PublicUserEntity {
    /**用户id*/
    private int id;
    /**用户登录名*/

    private String loginName;
    /**用户密码*/

    private String pwd;
    /**用户类型*/

    private int userType;

    /**个人用户真实姓名*/
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

    public PublicUserEntity(String loginName, String pwd, int userType, String realName, String jobInfo, String email, String homeAddress, String IDCardNum, String phone) {
        this.loginName = loginName;
        this.pwd = pwd;
        this.userType = userType;
        this.realName = realName;
        this.jobInfo = jobInfo;
        this.email = email;
        this.homeAddress = homeAddress;
        this.IDCardNum = IDCardNum;
        this.phone = phone;
    }
}
