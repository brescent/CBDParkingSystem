package com.project.entity;

import javax.persistence.*;

/**企业用户实体类*/

public class CompanyUserEntity {
    /**企业用户id*/

    private int id;

    /**企业名*/

    private String companyName;

    /**企业地址*/

    private String companyAddress;

    /**企业联系人*/

    private String contact;

    /**企业联系人电话*/

    private String contactPhone;


    private PublicUserEntity publicUser;

    public CompanyUserEntity() {
    }

    public CompanyUserEntity(String companyName, String companyAddress, String contact, String contactPhone) {
        this.companyName=companyName;
        this.companyAddress=companyAddress;
        this.contact=contact;
        this.contactPhone=contactPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public PublicUserEntity getPublicUser() {
        return publicUser;
    }

    public void setPublicUser(PublicUserEntity publicUser) {
        this.publicUser = publicUser;
    }
}
