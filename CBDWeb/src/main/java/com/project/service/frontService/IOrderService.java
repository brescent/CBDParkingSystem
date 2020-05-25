package com.project.service.frontService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient("frontService")
public interface IOrderService {
//    public  void  addOrder(FrontOrderEntity frontOrderEntity);
//    public void  delOrder(int id);
//    public void  updateOrder(FrontOrderEntity frontOrderEntity);
//    public FrontOrderEntity selOrder(int id);
//
//    public List<FrontOrderEntity> orderByUserid(int id);

    @RequestMapping("addOrder")
    public  void  addOrder(Map map);
    @RequestMapping("getAllOrderByUserId")
    public String getAllOrderByUserId(Map map);
    @RequestMapping("getOrderById")
    public String getOrderById(Map map);

}
