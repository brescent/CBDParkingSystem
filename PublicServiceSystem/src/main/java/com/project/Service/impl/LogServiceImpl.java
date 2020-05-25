package com.project.Service.impl;

import com.project.Service.ILogService;
import com.project.dao.ILogDao;
import com.project.entity.LogEntity;
import com.project.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements ILogService {

    @Autowired
    private ILogDao dao;

    @Override
    public PageEntity<LogEntity> findAll(int pageNum,int pageSize) {
        PageEntity<LogEntity> pageEntity = new PageEntity<>();
        Pageable pageable = PageRequest.of((pageNum-1),pageSize,new Sort(Sort.Direction.ASC,"logId"));
        Page<LogEntity> page = dao.findAll(pageable);
        pageEntity.setList(page.getContent());
        pageEntity.setPageNum(pageNum);
        pageEntity.setPageSize(pageSize);
        pageEntity.setCount((int) page.getTotalElements());
        return pageEntity;
    }


    @Override
    public void addLog(LogEntity logEntity) {
        dao.save(logEntity);
    }
}
