package com.lovo.back.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 企业合约与车位关系实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter(value= AccessLevel.PUBLIC)
@Setter(value= AccessLevel.PUBLIC)

@Entity
@Table(name="companyContract_stall")
public class CompanyContractAndStall implements Serializable {

    /*企业合约主键*/

@Id
@Column(name="pk_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


/*企业合约外键*/
@ManyToOne
@JoinColumn(name="fk_companyContractId")
private CompanyContractEntity  companyContract;


/*车位信息外键*/
@ManyToOne
@JoinColumn(name="fk_stallId")
private StallEntity  stall;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompanyContractEntity getCompanyContract() {
        return companyContract;
    }

    public void setCompanyContract(CompanyContractEntity companyContract) {
        this.companyContract = companyContract;
    }

    public StallEntity getStall() {
        return stall;
    }

    public void setStall(StallEntity stall) {
        this.stall = stall;
    }


}
