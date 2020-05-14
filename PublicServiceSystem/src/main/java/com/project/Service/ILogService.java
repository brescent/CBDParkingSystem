package com.project.Service;

import com.project.entity.LogEntity;

import java.util.List;

/**
 * 日志业务层接口
 */
public interface ILogService {
    /**
     * 查找全部日志
     * @return 日志集合
     */
    public List<LogEntity> findAll();

    /**
     * 通过用户id查找该用户日志
     * @param userId 用户id
     * @return 日志集合
     */
    public List<LogEntity> findByUserId(int userId);

    /**
     * 添加日志
     * @param logEntity 日志实体
     */
    public void addLog(LogEntity logEntity);

}
