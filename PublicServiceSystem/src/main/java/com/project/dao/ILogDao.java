package com.project.dao;

import com.project.entity.LogEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILogDao {
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
