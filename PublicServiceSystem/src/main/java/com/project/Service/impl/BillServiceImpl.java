package com.project.Service.impl;

import com.project.Service.IBillService;
import com.project.dao.IBillDao;
import com.project.entity.BillEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements IBillService {

    @Autowired
    private IBillDao dao;

    @Override
    public List<BillEntity> findByItem(int userId, Date startDate, Date endDate) {
        return dao.findByItem(userId,startDate,endDate);
    }

    @Override
    public BillEntity findById(int billId) {
        return dao.findById(billId);
    }

    @Override
    public void addBill(BillEntity billEntity) {
        dao.save(billEntity);
    }
}
