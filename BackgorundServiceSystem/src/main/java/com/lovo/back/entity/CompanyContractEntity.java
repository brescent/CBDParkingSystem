package com.lovo.back.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

/**
 * 企业合同实体
 */

@AllArgsConstructor

@Getter(value= AccessLevel.PUBLIC)
@Setter(value= AccessLevel.PUBLIC)

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    /*合同失效时间*/
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
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


    @Column(name="companyName",length = 48)
    private  String  companyName;

    @Column(name="linkMan",length = 48)
    private String linkMan;
    @Column(name="phone",length = 48)
    private String phone;


    /*车位*/
    @OneToMany(mappedBy = "companyContract",fetch=FetchType.EAGER)
    private Set<CompanyContractAndStall> set;

    /*合同生效状态*/
    private int state=1;

    public CompanyContractEntity() {
    }

    public CompanyContractEntity(String contractNo, Date startDate, Date endDate, double dealPrice, String contractImg, String oldContractNo) {
        this.contractNo = contractNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealPrice = dealPrice;
        this.contractImg = contractImg;
        this.oldContractNo = oldContractNo;
    }

    public CompanyContractEntity(String contractNo, Date startDate, Date endDate, double dealPrice, String contractImg, String oldContractNo, String companyName, String linkMan, String phone) {
        this.contractNo = contractNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dealPrice = dealPrice;
        this.contractImg = contractImg;
        this.oldContractNo = oldContractNo;
        this.companyName = companyName;
        this.linkMan = linkMan;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
    @JsonFormat(pattern="yyyy-MM-dd ",timezone="GMT+8")
    public Date getStartDate() {
        return startDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    @JsonFormat(pattern="yyyy-MM-dd ",timezone="GMT+8")
    public Date getEndDate() {
        return endDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd s")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getContractImg() {
        return contractImg;
    }

    public void setContractImg(String contractImg) {
        this.contractImg = contractImg;
    }

    public String getOldContractNo() {
        return oldContractNo;
    }

    public void setOldContractNo(String oldContractNo) {
        this.oldContractNo = oldContractNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<CompanyContractAndStall> getSet() {
        return set;
    }

    public void setSet(Set<CompanyContractAndStall> set) {
        this.set = set;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


}
