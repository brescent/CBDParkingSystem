package com.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**企业用户实体类*/
@Entity
@Table(name = "t_company")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class CompanyUserEntity {
    /**企业用户id*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_companyUserID")
    private int id;

    /**企业名*/
    @Column(name = "c_companyName")
    private String companyName;

    /**企业地址*/
    @Column(name = "c_companyAddress")
    private String companyAddress;

    /**企业联系人*/
    @Column(name = "c_contact")
    private String contact;

    /**企业联系人电话*/
    @Column(name = "c_contactPhone")
    private String contactPhone;

    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_publicUserId",referencedColumnName = "pk_publicUserId",nullable = false)
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
