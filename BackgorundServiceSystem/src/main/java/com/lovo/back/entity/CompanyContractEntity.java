package com.lovo.back.entity;


import lombok.*;


import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Optional;
import java.util.Set;

/**
 * 企业合同实体
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter(value= AccessLevel.PUBLIC)
@Setter(value= AccessLevel.PUBLIC)
@Data
@Entity
@Table(name = "t_companyContract")

public class CompanyContractEntity implements Serializable {

    @Id
    /*企业合同主键 唯一标志*/
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*企业合同编号*/
    @Column(name = "contractNo", length = 48)
    private String contractNo;
    /*合同生效时期*/
    @Column(name = "startDate")
    private Date startDate;
    /*合同失效时间*/
    @Column(name = "endDate")
    private Date endDate;
    /*合同成交价格*/
    @Column(name = "dealPrice")
    private double dealPrice;

    /*合同图片名称*/
    @Column(name = "contractImg", length = 88)
    private String contractImg;
    /*旧合同编号  可为空为续约合同  准备*/
    @Column(name = "oldContractNo", length = 88)
    private String oldContractNo;

    /*企业 对象*/
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "companyId")
    private CompanyEntity company;


    /*车位*/
    @OneToMany(mappedBy = "companyContract")
    private Set<CompanyContractAndStall> set;

    /*合同生效状态*/
    private int state=1;

    public CompanyContractEntity(String contractNo, Date startDate, Date endDate, double dealPrice, String contractImg, String oldContractNo) {
        this.contractNo = contractNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealPrice = dealPrice;
        this.contractImg = contractImg;
        this.oldContractNo = oldContractNo;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(Optional<CompanyEntity> company) {
        this.company = company.get();
    }
}
