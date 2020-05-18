package com.project.service.impl;

import com.project.dao.PactDao;
import com.project.entity.FrontOrderEntity;
import com.project.entity.FrontPactEntity;
import com.project.service.IPactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PactServicempl implements IPactService {
    @Autowired
    private PactDao pactDao;
    @Override
    public void addPact(FrontPactEntity frontPactEntity) {
        pactDao.save(frontPactEntity);
    }

    @Override
    public void delPact(int id) {
     pactDao.deleteById(id);
    }

    @Override
    public void updatePact(FrontPactEntity frontPactEntity) {
        pactDao.save(frontPactEntity);
    }

    @Override
    public FrontPactEntity selPact(int id) {

        return pactDao.findById(id).get();
    }
}
