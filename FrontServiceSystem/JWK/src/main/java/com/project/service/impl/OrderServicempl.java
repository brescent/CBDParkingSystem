package com.project.service.impl;

import com.project.dao.OrderDao;
import com.project.entity.FrontDealEntity;
import com.project.entity.FrontOrderEntity;
import com.project.entity.FrontUserInfoEntity;
import com.project.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServicempl implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(FrontOrderEntity frontOrderEntity) {
        orderDao.save(frontOrderEntity);
    }

    @Override
    public void delOrder(int id) {
  orderDao.deleteById(id);
    }

    @Override
    public void updateOrder(FrontOrderEntity frontOrderEntity) {
  orderDao.save(frontOrderEntity);
    }

    @Override
    public FrontOrderEntity  selOrder(int id) {
      return   orderDao.findById(id).get();
    }

    @Override
    public List<FrontOrderEntity> orderByUserid(int id) {
        return orderDao.orderByUserid(id);
    }

    @Override
    public List<Map> getAllOrderByUserId(int id) {
        return orderDao.getAllOrderByUserId(id);
    }

    @Override
    public List<Map> getOrderById(int id) {
        return orderDao.getOrderById(id);
    }
}
