package com.project.service.impl;

import com.project.dao.StallDao;
import com.project.entity.FrontStallEntity;
import com.project.entity.FrontUserInfoEntity;
import com.project.service.IStallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StallServcempl  implements IStallService {
    @Autowired
    private StallDao stallDao;
    @Override
    public int addStall(FrontStallEntity frontStallEntity) {
        FrontStallEntity f=  stallDao.save(frontStallEntity);
        return f.getId();
    }

    @Override
    public void delStall(int id) {
        stallDao.deleteById(id);
    }

    @Override
    public void updateStall(FrontStallEntity frontStallEntity) {
        stallDao.save(frontStallEntity);
    }

    @Override
    public FrontStallEntity  selStall(int id) {

        return stallDao.findById(id).get();
    }

    @Override
    public List<FrontStallEntity> getStallByUserId(int id) {
        return stallDao.getStallByUserId(id);
    }
}
