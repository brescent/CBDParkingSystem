package com.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient("backServerClient")
public interface IReleaseSellService {

    @PostMapping("/stall/addSingle")
    void addSingle(String  stallAddress,String stallNo,String peopleNo,String stallImg);

}
