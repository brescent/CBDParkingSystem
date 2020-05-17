package com.project.service;

import com.project.entity.FrontDealEntity;

public interface IDealService {
    public  void  addDeal(FrontDealEntity frontDealEntity);
    public FrontDealEntity delDeal(int id);
    public void  updateDeal(FrontDealEntity frontDealEntity);
    public FrontDealEntity selDeal(int id);
}

