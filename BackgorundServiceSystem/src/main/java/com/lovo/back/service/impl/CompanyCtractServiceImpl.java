package com.lovo.back.service.impl;

import com.lovo.back.dao.ICompanyContractAndStallDao;
import com.lovo.back.dao.ICompanyContractDao;
import com.lovo.back.entity.CompanyContractAndStall;
import com.lovo.back.entity.CompanyContractEntity;
import com.lovo.back.service.ICompanyContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyCtractServiceImpl implements ICompanyContractService {

    @Autowired
    ICompanyContractDao companyContractDao;
    @Autowired
    ICompanyContractAndStallDao companyContractAndStallDao;


    @Override
    public List<CompanyContractEntity> findAll() {
        return (List<CompanyContractEntity>) companyContractDao.findAll();
    }

    @Override
    public void add(CompanyContractEntity companyContractEntity) {
        companyContractDao.save(companyContractEntity);
    }

    @Override
    public void updateState(int id) {
        companyContractDao.updateState(id);
    }

    @Override
    public Optional<CompanyContractEntity> findById(int id) {
        return companyContractDao.findById(id);
    }



    public void addCompanyContractAndStall(CompanyContractAndStall  companyContractAndStall){
        companyContractAndStallDao.save(companyContractAndStall);
    }

}
