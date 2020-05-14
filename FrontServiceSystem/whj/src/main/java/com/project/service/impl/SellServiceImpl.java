package com.project.service.impl;

import com.project.dao.SellDao;
import com.project.entity.frontStallEntity;
import com.project.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "SellService")
public class SellServiceImpl implements SellService {

    @Autowired
    private SellDao sellDao;

    @Override
    public void saveReleaseSell(frontStallEntity frontStallEntity) {
        sellDao.save(frontStallEntity);
    }

}
