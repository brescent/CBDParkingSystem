package com.lovo.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;


/**
 * 外部合约实体类  cbd系统与其他平台签订的合约
 */

@Data
@Entity
@Table(name="t_outContract")
public class OutContractEntity implements Serializable {
    @Id
     /*外部合同主键 唯一标志*/
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*外部合约编号*/
    @Column(length=88)
    private String outContractNo;
    /*合同单位*/
    @Column(length=88)
    private  String unit;
    /*双方联系人*/
    @Column(length = 48)
    private String bothParties;
    /*对方联系人*/
    @Column(length = 48)
    private String  linkMan;
    /*合同生效日期*/
    private Date startDate;
    /*合同失效日期*/
    private  Date  endDate;
   /*成交价格*/
    private  double dealPrice;

   /*合约图片名称*/
    @Column(length = 88)
    private  String contractImg ;

    /*旧合同编号*/
    @Column(length = 88)
    private String oldOutContractNo;

    /*车位信息*/
    @OneToMany(mappedBy = "outContract",fetch=FetchType.EAGER)
    private Set<OutContractAndStall> outContractAndStallSet;

    public Set<OutContractAndStall> getOutContractAndStallSet() {
        return outContractAndStallSet;
    }

    public void setOutContractAndStallSet(Set<OutContractAndStall> outContractAndStallSet) {
        this.outContractAndStallSet = outContractAndStallSet;
    }

    /*合同生效状态*/
    private int state=1;

    public OutContractEntity() {
    }

    public OutContractEntity(String outContractNo, String unit, String bothParties, String linkMan, Date startDate, Date endDate, double dealPrice, String contractImg, String oldOutContractNo) {
        this.outContractNo = outContractNo;
        this.unit = unit;
        this.bothParties = bothParties;
        this.linkMan = linkMan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealPrice = dealPrice;
        this.contractImg = contractImg;
        this.oldOutContractNo = oldOutContractNo;
    }

}
