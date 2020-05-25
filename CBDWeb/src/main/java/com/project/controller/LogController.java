package com.project.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.netflix.discovery.converters.Auto;
import com.project.entity.LogEntity;
import com.project.entity.PageEntity;
import com.project.service.IPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {
    @Autowired
    IPublicService service;

    @GetMapping("findLog")
    public String findAllLog(int pageNum,int pageSize){
        String logJson = null;
       PageEntity<LogEntity> page= service.findAllLog(pageNum, pageSize);
       logJson = JSON.toJSONString(page);

        return logJson;
    }


}

