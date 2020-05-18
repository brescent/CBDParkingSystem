package com.project.Service;

import com.project.entity.LogEntity;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 日志业务层接口
 */
@FeignClient("logService")
public interface ILogService {
    /**
     * 查找全部日志
     * @return 日志集合
     */
    public List<LogEntity> findAll();

    /**
     * 添加日志
     * @param logEntity 日志实体
     */
    public void addLog(LogEntity logEntity);

}
