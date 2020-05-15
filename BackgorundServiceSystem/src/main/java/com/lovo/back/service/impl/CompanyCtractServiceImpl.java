package com.lovo.back.service.impl;

import com.lovo.back.dao.ICompanyContractAndStallDao;
import com.lovo.back.dao.ICompanyContractDao;
import com.lovo.back.entity.CompanyContractAndStall;
import com.lovo.back.entity.CompanyContractEntity;
import com.lovo.back.entity.OutContractAndStall;
import com.lovo.back.entity.StallEntity;
import com.lovo.back.service.ICompanyContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service(value = "companyContract")
public class CompanyCtractServiceImpl implements ICompanyContractService {

    @Autowired
    ICompanyContractDao companyContractDao;

    @Autowired
    ICompanyContractAndStallDao companyContractAndStallDao;


    @Override
    public List<CompanyContractEntity> findAll() {
        return (List<CompanyContractEntity>) companyContractDao.findAll();
    }


    /**
     * 添加 企业合约 并向
     * @param companyContractEntity
     * @param stallIdList
     */
    @Override
    public void add(CompanyContractEntity companyContractEntity,int [] stallIdList) {
        companyContractDao.save(companyContractEntity);


        for(int stallId:stallIdList){
            CompanyContractAndStall obj=new CompanyContractAndStall();
            StallEntity stall=new StallEntity();

            stall.setId(stallId);
            obj.setCompanyContract(companyContractEntity);

            obj.setStall(stall);

            companyContractAndStallDao.save(obj);

        }
    }

    @Override
    public void updateState(int id) {
        companyContractDao.updateState(id);
    }

    @Override
    public CompanyContractEntity findById(int id) {
        return companyContractDao.findById(id).get();
    }




}
