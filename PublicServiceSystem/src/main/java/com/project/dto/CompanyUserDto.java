package com.project.dto;


public class CompanyUserDto {
    private int id;
    private String loginName;
    private String pwd;
    private String companyName;
    private String companyAddress;
    private String contact;
    private String contactPhone;

    public CompanyUserDto() {
    }

    public CompanyUserDto(int id, String loginName, String pwd, String companyName, String companyAddress, String contact, String contactPhone) {
        this.id = id;
        this.loginName = loginName;
        this.pwd = pwd;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contact = contact;
        this.contactPhone = contactPhone;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

}
