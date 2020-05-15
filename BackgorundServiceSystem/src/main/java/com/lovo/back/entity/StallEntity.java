package com.lovo.back.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter(value= AccessLevel.PUBLIC)
@Setter(value= AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
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


    /*车位有效性 0表示无效 1表示有效*/
    @Column(length = 48)
    private int valid=0;

    /*外部合约*/
    @OneToMany(mappedBy = "stall")
    private Set<OutContractAndStall> outSet;
   /*企业合约*/

    @OneToMany(mappedBy = "stall")
    private Set<CompanyContractAndStall> companySet;

    public StallEntity(String stallAddress, String stallNo, String stallImg, String peopleNo) {
        this.stallAddress = stallAddress;
        this.stallNo = stallNo;
        this.stallImg = stallImg;
        this.peopleNo = peopleNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStallAddress() {
        return stallAddress;
    }

    public void setStallAddress(String stallAddress) {
        this.stallAddress = stallAddress;
    }

    public String getStallNo() {
        return stallNo;
    }

    public void setStallNo(String stallNo) {
        this.stallNo = stallNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStallImg() {
        return stallImg;
    }

    public void setStallImg(String stallImg) {
        this.stallImg = stallImg;
    }

    public String getPeopleNo() {
        return peopleNo;
    }

    public void setPeopleNo(String peopleNo) {
        this.peopleNo = peopleNo;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public Set<OutContractAndStall> getOutSet() {
        return outSet;
    }

    public void setOutSet(Set<OutContractAndStall> outSet) {
        this.outSet = outSet;
    }

    public Set<CompanyContractAndStall> getCompanySet() {
        return companySet;
    }

    public void setCompanySet(Set<CompanyContractAndStall> companySet) {
        this.companySet = companySet;
    }
}
