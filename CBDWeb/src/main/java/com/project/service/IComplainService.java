package com.project.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("frontService")
public interface IComplainService {


    @GetMapping("getAllComplaintlist")
    public String findAll();


    @GetMapping("getById/{id}")
    public String findById(@PathVariable("id") int id);


    @GetMapping("updateComplaintById/{id}/{state}")
    public void updateComplaintById(@PathVariable("id") int id, @PathVariable("id") int state);


}
