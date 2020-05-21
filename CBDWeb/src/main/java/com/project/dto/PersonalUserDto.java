package com.project.dto;

/**
 * 用户修改信息专用dto
 */
public class PersonalUserDto {
    private String userName;
    private String pwd;
    private String email;
    private String phone;
    private String homeAddress;
    private String jobInfo;

    public PersonalUserDto() {
    }

    public PersonalUserDto(String userName, String pwd, String email, String phone, String homeAddress, String jobInfo) {
        this.userName = userName;
        this.pwd = pwd;
        this.email = email;
        this.phone = phone;
        this.homeAddress = homeAddress;
        this.jobInfo = jobInfo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public String getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(String jobInfo) {
        this.jobInfo = jobInfo;
    }
}
