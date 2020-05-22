package com.project.service.impl;

import com.project.dao.PactDao;
import com.project.entity.FrontPactEntity;
import com.project.service.IPactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "pactService")
public class PactServiceImpl implements IPactService {

    @Autowired
    private PactDao pactDao;

    @Override
    public void addPact(FrontPactEntity frontPactEntity) {

        pactDao.save(frontPactEntity);

    }
}
