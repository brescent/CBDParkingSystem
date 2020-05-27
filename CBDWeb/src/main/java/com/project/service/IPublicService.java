package com.project.service;

import com.project.entity.BillEntity;
import com.project.entity.LogEntity;
import com.project.entity.MessageEntity;
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

    @GetMapping("findLog")
    public PageEntity<LogEntity> findAllLog(@RequestParam int pageNum,@RequestParam int pageSize);

    @GetMapping("findMessageList")
    public PageEntity<MessageEntity> findMessageList(@RequestParam String userName,@RequestParam int pageNum,@RequestParam int pageSize);

    @RequestMapping("readMessage")
    public MessageEntity readMessage(@RequestParam int messageId);

    @RequestMapping("deleteMessage")
    void deleteMessage(@RequestParam int messageId);
}
