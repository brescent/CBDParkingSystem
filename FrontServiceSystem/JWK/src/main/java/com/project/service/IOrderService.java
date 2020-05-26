package com.project.service;

import com.project.entity.FrontDealEntity;
import com.project.entity.FrontOrderEntity;
import com.project.entity.FrontUserInfoEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface IOrderService {
    public  void  addOrder(FrontOrderEntity frontOrderEntity);
    public void  delOrder(int id);
    public void  updateOrder(FrontOrderEntity frontOrderEntity);
    public FrontOrderEntity selOrder(int id);

    public List<FrontOrderEntity> orderByUserid(int id);
    public List<Map> getAllOrderByUserId(int id);
    public List<Map> getOrderById(int id);
}
