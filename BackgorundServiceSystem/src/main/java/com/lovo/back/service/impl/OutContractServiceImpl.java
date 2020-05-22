package com.lovo.back.service.impl;

import com.lovo.back.dao.IOutContractAndStallDao;
import com.lovo.back.dao.IOutContractDao;
import com.lovo.back.dao.IStallDao;
import com.lovo.back.entity.*;
import com.lovo.back.service.IOutContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service(value="outContract")
public class OutContractServiceImpl implements IOutContractService {


    @Autowired
    IOutContractDao outContractDao;


    @Autowired
    IStallDao stallDao;
    @Autowired
    IOutContractAndStallDao outContractAndStallDao;

    @Override
    public List<OutContractEntity> findAll() {

        return (List<OutContractEntity>) outContractDao.findAll();
    }

    @Override
    public void add(OutContractEntity outContractEntity ,List<Integer> stallIdList) {
        outContractDao.save(outContractEntity);

        for(int stallId:stallIdList){
            OutContractAndStall  obj=new OutContractAndStall();
            StallEntity stall=new StallEntity();

            stall.setId(stallId);
            obj.setOutContract(outContractEntity);
            obj.setStall(stall);

            outContractAndStallDao.save(obj);

        }

    }

    @Override
    public void updateState(int id) {


     outContractDao.updateState(id);
     Iterator<OutContractAndStall> iterator= outContractDao.findById(id).get().getOutContractAndStallSet().iterator();

        while(iterator.hasNext()) {
            //iterator.next()返回迭代的下一个元素
           stallDao.updateState(iterator.next().getId(),0);
        }
    }

    @Override
    public OutContractEntity findById(int id) {

        Optional<OutContractEntity> optional = outContractDao.findById(id);
        if (optional != null && optional.isPresent()) {

            return outContractDao.findById(id).get();
        }

        return null;
    }

    @Override
    public PaginationBean<OutContractEntity> findByPage(int currentPage, int pageSize) {

        PaginationBean paginationBean=new PaginationBean();

        Pageable pageable=new PageRequest((currentPage-1),pageSize);

        paginationBean.setCurrentPage(currentPage);
        paginationBean.setPageSize(pageSize);
        paginationBean.setDataList(outContractDao.findByPage(pageable));
        int totalPage=0;

        if((outContractDao.findByItemsCount().get(0).intValue())%pageSize!=0){
            totalPage=(outContractDao.findByItemsCount().get(0).intValue())/pageSize+1;

        }else{
            totalPage=(outContractDao.findByItemsCount().get(0).intValue())/pageSize;
        }

        paginationBean.setTotal(totalPage);

paginationBean.setCount(outContractDao.findByItemsCount().get(0).intValue());

        paginationBean.setPageSize(outContractDao.findByItemsCount().get(0).intValue());
        return paginationBean;


    }
}
