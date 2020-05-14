package com.project.Service.impl;

import com.project.Service.ILogService;
import com.project.dao.ILogDao;
import com.project.entity.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements ILogService {

    @Autowired
    private ILogDao dao;

    @Override
    public List<LogEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public void addLog(LogEntity logEntity) {
        dao.save(logEntity);
    }
}
