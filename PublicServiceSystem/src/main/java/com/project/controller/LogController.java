package com.project.controller;

import com.project.Service.ILogService;
import com.project.entity.LogEntity;
import com.project.util.CBDStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 日志控制层
 */
@RestController
public class LogController {

    @Autowired
    private ILogService logService;

    /**
     * 添加日志
     * @param logInfo 日志内容
     * @param userName 操作用户名
     */
    @PostMapping("addLog/{userName}/{logInfo}")
    public String addLog(@PathVariable("logInfo") String logInfo,@PathVariable("userName") String userName){
        logService.addLog(new LogEntity(logInfo,userName));
        return CBDStringUtil.ADD_SUCCESS;
    }

    @GetMapping("find")
    public List<LogEntity> findLogList(){
        List<LogEntity> logList = logService.findAll();
        return logList;
    }
}
