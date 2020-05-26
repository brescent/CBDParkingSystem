package com.project.service.frontService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("frontService")
public interface IDealService {
@PostMapping("addDeal")
   public  void  addDeal(Map map);
//    public FrontDealEntity delDeal(int id);
//    public void  updateDeal(FrontDealEntity frontDealEntity);
//    public FrontDealEntity selDeal(int id);
@RequestMapping("/detDealById")
public  String detDealById(Map map);

    @RequestMapping("updateDealById/{id}/{state}")
    public void updateDealById(@RequestParam("id") int id, @RequestParam("id") int state);
    @RequestMapping("getAllDeallist")
    public String getAllDeallist();
}

