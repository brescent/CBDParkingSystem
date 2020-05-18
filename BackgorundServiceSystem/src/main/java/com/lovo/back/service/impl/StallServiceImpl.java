package com.lovo.back.service.impl;

import com.lovo.back.dao.IStallDao;
import com.lovo.back.entity.PaginationBean;
import com.lovo.back.entity.StallEntity;
import com.lovo.back.service.IStallService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 车位管理服务
 */
@Service(value="stall")
public class StallServiceImpl  implements IStallService {
    @Autowired
    IStallDao stallDao;



    @Override
    public List<StallEntity> findByState() {
        return stallDao.findByState();
    }

    @Override
    public PaginationBean<StallEntity> findByItems(String stallAddress, String stallNo, int page, int size) {
        PaginationBean paginationBean=new PaginationBean();

        Pageable pageable=new PageRequest((page-1),size);

        paginationBean.setCurrentPage(page);
        paginationBean.setPageSize(size);
        paginationBean.setDataList(stallDao.findByItems(stallAddress,stallNo,pageable));
        int totalPage=0;

        if((stallDao.findByItemsCount(stallAddress,stallNo).get(0).intValue())%size!=0){
            totalPage=(stallDao.findByItemsCount(stallAddress,stallNo).get(0).intValue())/size+1;

        }else{
            totalPage=(stallDao.findByItemsCount(stallAddress,stallNo).get(0).intValue())/size;
        }

        paginationBean.setTotal(totalPage);



        paginationBean.setTotal(totalPage);
        return paginationBean;
    }

    @Override
    public void updatePeopleNo(int id, String peopleNum) {
    stallDao.updatePeopleNo(id,peopleNum);
    }

    @Override
    public void add(String  stallAddress,String addressNo, int total, int startNum) {


        for (int i=startNum;i<total+startNum;i++){
            StallEntity stall=new StallEntity();
            stall.setStallAddress( stallAddress);
            stall.setStallNo(addressNo+i);
             stall.setValid(1);
            stallDao.save(stall);

        }
    }

    @Override
    public List<StallEntity> findAll() {
        return stallDao.findAll();
    }


    @Override
    public void addSingle(String stallAddress, String stallNo, String peopleNo, String stallImg) {

        StallEntity stall= new StallEntity();
        stall.setStallAddress(stallAddress);
        stall.setStallNo(stallNo);
        stall.setPeopleNo(peopleNo);
        stall.setStallImg(stallImg);

        stallDao.save(stall);
    }

    @Override
    public void updateValid(int id) {


        stallDao.updateValid(id);
    }

    @Override
    public List<StallEntity> findNoValid() {
        return stallDao.findNoValid();
    }

    @Override
    public StallEntity findByPeopleNo(String peopleNo) {
        return stallDao.findByPeopleNo(peopleNo);
    }

    @Override
    public StallEntity addAndReturn(StallEntity stall) {
        return stallDao.save(stall);
    }
}