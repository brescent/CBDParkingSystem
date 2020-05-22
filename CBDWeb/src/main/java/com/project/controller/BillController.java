package com.project.controller;

import com.alibaba.fastjson.JSON;
import com.project.dto.UserDto;
import com.project.entity.BillEntity;
import com.project.entity.PageEntity;
import com.project.entity.PublicUserEntity;
import com.project.service.IPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@RestController
public class BillController {

    @Autowired
    private IPublicService publicService;

    @GetMapping("findBillList")
    public String findBillList(String startDateStr, String endDateStr,
                               int pageSize, int pageNum,  HttpServletRequest request){
        String pageJson = null;
        Date startDate = null;
        Date endDate = null;
        if (startDateStr != "" && startDateStr != null){
            startDate = Date.valueOf(startDateStr);
        }
        if (endDateStr != "" && endDateStr != null){
            endDate = Date.valueOf(endDateStr);
        }

        UserDto user = (UserDto) request.getSession().getAttribute("user");
        int userId = user.getId();
        PageEntity<BillEntity> page = null;
        try {
            page = publicService.findBillList(userId,startDate,endDate,pageSize,pageNum);
        }catch (Exception e){
            e.printStackTrace();
        }
        pageJson = JSON.toJSONString(page);
        System.out.println(pageJson);

        return pageJson;
    }
}
