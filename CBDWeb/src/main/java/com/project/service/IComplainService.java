package com.project.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient("frontServiceSystem")
public interface IComplainService {

    @GetMapping("/getAllComplaintList")
    public String findAllComplaint();



    @GetMapping("/updateComplaintById")
    public void updateState(@RequestParam("id") String id,@RequestParam("state") String state);



    @GetMapping("/findComplaintById")
    public  String findComplaintById(@RequestParam("id")String id);

}
