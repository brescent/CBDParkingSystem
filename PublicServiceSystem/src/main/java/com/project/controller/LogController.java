package com.project.controller;

import com.project.Service.ILogService;
import com.project.entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 日志控制层
 */
@RequestMapping("log")
public class LogController {

    @Autowired
    private ILogService logService;

    /**
     * 添加日志
     * @param logInfo 日志内容
     * @param userName 操作用户名
     */
    @RequestMapping("add")
    public void addLog(String logInfo,String userName){
        logService.addLog(new LogEntity(logInfo,userName));
    }
}
