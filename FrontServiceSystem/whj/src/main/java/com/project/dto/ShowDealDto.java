package com.project.dto;

public interface ShowDealDto {

    Integer getdealId();
    /**
     * 车位地址
     */
    String getstallAddress();
    /**
     * 身份证号码
     */
    String getidnum();
    /**
     * 交易价格
     */
    float getdealPrice();
    /**
     * 职业
     */
    String getprofession();
    /**
     * 真实姓名
     */
    String getrealName();
    /**
     * 用户名
     */
    String getuserName();
    /**
     * 车位编号
     */
    String getstallNum();
}
