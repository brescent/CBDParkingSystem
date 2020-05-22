package com.project.service;

import com.project.entity.BillEntity;
import com.project.entity.PageEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@FeignClient("publicUserService")
public interface IPublicService {
    @PostMapping("addLog/{userName}/{logInfo}")
    public void addLog(@PathVariable("userName") String userName, @PathVariable("logInfo") String logInfo);

    @GetMapping("findBillList")
    public PageEntity<BillEntity> findBillList(@RequestParam int userId, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam int pageSize, @RequestParam int pageNum);
}
