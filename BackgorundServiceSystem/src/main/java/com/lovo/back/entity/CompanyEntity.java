package com.lovo.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="t_company")
public class CompanyEntity implements Serializable {



    /**企业用户id*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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



}
