package com.project.service.impl;

import com.project.dao.ComplaintDao;
import com.project.entity.FrontcomplaintEntity;
import com.project.service.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Complaintmpl implements IComplaintService {

    @Autowired
    private ComplaintDao complaintDao;

    @Override
    public void addComplanit(FrontcomplaintEntity frontcomplaintEntity) {
        complaintDao.save(frontcomplaintEntity);
    }

    @Override
    public void delComplaint(int id) {
   complaintDao.deleteById(id);
    }

    @Override
    public FrontcomplaintEntity selComplaint(int id) {
        Optional<FrontcomplaintEntity> optional= complaintDao.findById(id);
       return optional.get();
    }
}
