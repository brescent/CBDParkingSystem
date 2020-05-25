package com.project.service;

import com.project.entity.FrontDealEntity;

import java.util.List;
import java.util.Map;

public interface IDealService {
    public  void  addDeal(FrontDealEntity frontDealEntity);
    public FrontDealEntity delDeal(int id);
    public void  updateDeal(FrontDealEntity frontDealEntity);
    public FrontDealEntity selDeal(int id);
    public List<Map> getAllDeal();
    public void updateDealById( int id , int state);
    public List<Map> getDealById(int id);
}

