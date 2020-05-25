package com.project.Service.impl;

import com.project.Service.IBillService;
import com.project.dao.IBillDao;
import com.project.entity.BillEntity;
import com.project.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public PageEntity<BillEntity> findByItem(int userId, Date startDate, Date endDate, int pageSize, int pageNum) {
        PageEntity<BillEntity> pageEntity = new PageEntity<BillEntity>();
        Pageable pageable = PageRequest.of(pageNum-1,pageSize,new Sort(Sort.Direction.ASC,"b_trade_date"));
        Page<BillEntity> page =  dao.findByItem(userId,startDate,endDate,pageable);
        List<BillEntity> list = page.getContent();
        for (BillEntity b:list) {
            System.out.println(b.getBillId());
        }
        pageEntity.setList(list);
        pageEntity.setPageSize(pageSize);
        pageEntity.setPageNum(pageNum);
        pageEntity.setCount((int) page.getTotalElements());
        return pageEntity;
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
