package com.project.dto;


import lombok.Data;

@Data
public class UserInfoDto {
    /**
     * 职业
     */
    private String userProfession;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 身份证号
     */
    private String IDNum;
}
