package com.lovo.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Data
@Entity
@Table(name = "t_stall")
public class StallEntity implements Serializable {

    @Id
    /*车位主键 唯一标志*/
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*车位地址*/
    @Column(length = 48)
    private String stallAddress;

    /*车位编号*/
    @Column(length = 48)
    private String stallNo;
    /*车位状态   0表示空闲  1表示 出租中*/
    private int state;

    @Column(length = 48)
    /*车位产权图片名称*/
    private String stallImg;

    /*身份证号*/
    @Column(length = 48)
    private String peopleNo;

    /*外部合约*/
    @OneToMany(mappedBy = "stall")
    private Set<OutContractAndStall> outSet;
   /*企业合约*/

    @OneToMany(mappedBy = "stall")
    private Set<CompanyContractAndStall> companySet;
}
