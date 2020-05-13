package com.lovo.back.service.impl;

import com.lovo.back.dao.IOutContractAndStallDao;
import com.lovo.back.dao.IOutContractDao;
import com.lovo.back.entity.CompanyContractAndStall;
import com.lovo.back.entity.OutContractAndStall;
import com.lovo.back.entity.OutContractEntity;
import com.lovo.back.service.IOutContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OutContractServiceImpl implements IOutContractService {


    @Autowired
    IOutContractDao outContractDao;

    @Autowired
    IOutContractAndStallDao outContractAndStallDao;

    @Override
    public List<OutContractEntity> findAll() {

        return (List<OutContractEntity>) outContractDao.findAll();
    }

    @Override
    public void add(OutContractEntity outContractEntity) {
        outContractDao.save(outContractEntity);
    }

    @Override
    public void updateState(int id) {
        outContractDao.updateState(id);
    }

    @Override
    public Optional<OutContractEntity> findById(int id) {

        return outContractDao.findById(id);
    }


    public void addOutContractAndStall(OutContractAndStall outContractAndStall){
        outContractAndStallDao.save(outContractAndStall);
    }
}
