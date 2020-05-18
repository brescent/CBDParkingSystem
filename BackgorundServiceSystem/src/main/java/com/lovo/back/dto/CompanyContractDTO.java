package com.lovo.back.dto;

import com.lovo.back.entity.CompanyContractEntity;
import com.lovo.back.entity.CompanyEntity;
import com.lovo.back.service.impl.CompanyCtractServiceImpl;

public class CompanyContractDTO {

    private CompanyEntity company;


    private CompanyContractEntity  companyContract;

    public CompanyContractDTO() {
    }

    public CompanyContractDTO(CompanyEntity company, CompanyContractEntity companyContract) {
        this.company = company;
        this.companyContract = companyContract;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public CompanyContractEntity getCompanyContract() {
        return companyContract;
    }

    public void setCompanyContract(CompanyContractEntity companyContract) {
        this.companyContract = companyContract;
    }
}
