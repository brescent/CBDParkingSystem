package com.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("publicUserService")
public interface IPublicService {
    @RequestMapping("addLog/{userName}/{logInfo}")
    public void addLog(@PathVariable("userName") String userName, @PathVariable("logInfo") String logInfo);





}
