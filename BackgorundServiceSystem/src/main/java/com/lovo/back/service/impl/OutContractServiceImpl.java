package com.lovo.back.service.impl;

import com.lovo.back.dao.IOutContractAndStallDao;
import com.lovo.back.dao.IOutContractDao;
import com.lovo.back.entity.CompanyContractAndStall;
import com.lovo.back.entity.OutContractAndStall;
import com.lovo.back.entity.OutContractEntity;
import com.lovo.back.entity.StallEntity;
import com.lovo.back.service.IOutContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service(value="outContract")
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
    public void add(OutContractEntity outContractEntity ,int [] stallIdList) {
        outContractDao.save(outContractEntity);

        for(int stallId:stallIdList){
            OutContractAndStall  obj=new OutContractAndStall();
            StallEntity stall=new StallEntity();

            stall.setId(stallId);
            obj.setOutContract(outContractEntity);
            obj.setStall(stall);

            outContractAndStallDao.save(obj);

        }

    }

    @Override
    public void updateState(int id) {
        outContractDao.updateState(id);
    }

    @Override
    public Optional<OutContractEntity> findById(int id) {

        return outContractDao.findById(id);
    }



}
