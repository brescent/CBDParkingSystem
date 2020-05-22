package com.project.service.impl;


import com.project.dao.DealDao;
import com.project.dao.OrderDao;
import com.project.entity.FrontDealEntity;
import com.project.entity.FrontOrderEntity;
import com.project.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "orderService")
public class OrderServiceIml implements IOderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private DealDao dealDao;


    @Override
    public void saveOrder(String message, int id) {
        FrontOrderEntity frontOrderEntity = new FrontOrderEntity();
        FrontDealEntity frontDealEntity =  dealDao.getDealById2(id);
        frontOrderEntity.setFrontDealEntity(frontDealEntity);
        frontOrderEntity.setFrontUserInfoId(frontDealEntity.getFrontStallId().getStall());
        frontOrderEntity.setOrderState(0);
        frontOrderEntity.setMessage(message);
        orderDao.save(frontOrderEntity);
    }
}
