package com.project.dao;

import com.project.entity.LogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 日志持久层接口
 */
public interface ILogDao extends CrudRepository<LogEntity,Integer> {
    /**
     * 查找全部日志
     * @return 日志集合
     */
    @Query("from LogEntity")
    public List<LogEntity> findAll();

//    /**
//     * 添加日志
//     * @param logEntity 日志实体
//     */
//    public void addLog(LogEntity logEntity);
}
