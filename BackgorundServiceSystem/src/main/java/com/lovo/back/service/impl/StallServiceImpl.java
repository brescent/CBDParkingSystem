package com.lovo.back.service.impl;

import com.lovo.back.dao.IStallDao;
import com.lovo.back.entity.StallEntity;
import com.lovo.back.service.IStallService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class StallServiceImpl  implements IStallService {
    @Autowired
    IStallDao stallDao;



    @Override
    public List<StallEntity> findByState() {
        return stallDao.findByState();
    }

    @Override
    public List<StallEntity> findByItems(String stallAddress, String stallNo, int page,int size) {
        Pageable pageable=PageRequest.of(page, size);

        return stallDao.findByItems(stallAddress,stallNo,pageable);
    }

    @Override
    public void updatePeopleNo(int id, String peopleNum) {
    stallDao.updatePeopleNo(id,peopleNum);
    }

    @Override
    public void add(String  stallAddress,String addressNo, int total, int startNum) {

        for (int i=startNum;i<total+startNum;i++){
            StallEntity stall=new StallEntity();
            stall.setStallAddress(stallAddress);
            stall.setStallNo(startNum+addressNo);

            stallDao.save(stall);
        }
    }

    @Override
    public List<StallEntity> findAll() {
        return stallDao.findAll();
    }
}