package com.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Map;


@FeignClient("backServerClient")
public interface IReleaseSellService {

    @PostMapping("/stall/addSingle")
    void addSingle(@RequestBody Map<String, String> map);

}
