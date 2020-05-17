package com.project.dto;

/**
 * 用户修改信息专用dto
 */
public class PersonalUserDto {
    private String pwd;
    private String email;
    private String phone;
    private String homeAddress;
    private String jonInfo;

    public PersonalUserDto() {
    }

    public PersonalUserDto(String email, String phone, String homeAddress, String jonInfo, String pwd
    ) {
        this.pwd=pwd;
        this.email = email;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.jonInfo = jonInfo;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getJonInfo() {
        return jonInfo;
    }

    public void setJonInfo(String jonInfo) {
        this.jonInfo = jonInfo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
