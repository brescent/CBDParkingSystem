package com.project.service.impl;

import com.project.dao.DealDao;
import com.project.entity.FrontDealEntity;
import com.project.service.IDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealServicempl implements IDealService {
    @Autowired
    private DealDao dealDao;

    @Override
    public void addDeal(FrontDealEntity frontDealEntity) {
        dealDao.save(frontDealEntity);
    }

    @Override
    public FrontDealEntity delDeal(int id) {
dealDao.deleteById(id);
        return null;
    }

    @Override
    public void updateDeal(FrontDealEntity frontDealEntity) {
  dealDao.save(frontDealEntity);
    }

    @Override
    public FrontDealEntity selDeal(int id) {

      return   dealDao.findById(id).get();
    }
}
