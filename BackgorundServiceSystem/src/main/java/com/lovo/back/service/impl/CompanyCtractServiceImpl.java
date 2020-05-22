package com.lovo.back.service.impl;

import com.lovo.back.dao.ICompanyContractAndStallDao;
import com.lovo.back.dao.ICompanyContractDao;
import com.lovo.back.dao.IStallDao;
import com.lovo.back.entity.*;
import com.lovo.back.service.ICompanyContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service(value = "companyContract")
public class CompanyCtractServiceImpl implements ICompanyContractService {

    @Autowired
    ICompanyContractDao companyContractDao;

    @Autowired
    ICompanyContractAndStallDao companyContractAndStallDao;
@Autowired
   IStallDao stallDao;


    @Override
    public List<CompanyContractEntity> findAll() {
        return (List<CompanyContractEntity>) companyContractDao.findAll();
    }


    /**
     * 添加 企业合约 并向
     * @param companyContractEntity
     * @param stallIdList
     */
    @Override
    public void add(CompanyContractEntity companyContractEntity,List<Integer> stallIdList) {
        companyContractDao.save(companyContractEntity);


        for(int stallId:stallIdList){
            CompanyContractAndStall obj=new CompanyContractAndStall();

            stallDao.updateState(stallId,1);
            StallEntity stall=new StallEntity();

            stall.setId(stallId);

            obj.setCompanyContract(companyContractEntity);

            obj.setStall(stall);

            companyContractAndStallDao.save(obj);

        }
    }

    @Override
    public void updateState(int id) {
        companyContractDao.updateState(id);

        Iterator<CompanyContractAndStall> iterator= companyContractDao.findById(id).get().getSet().iterator();

        while(iterator.hasNext()) {
            //iterator.next()返回迭代的下一个元素
            stallDao.updateState(iterator.next().getId(),0);
        }



    }

    @Override
    public CompanyContractEntity findById(int id) {

        Optional<CompanyContractEntity> optional=companyContractDao.findById(id);
        if(optional!=null&&optional.isPresent()){
            return companyContractDao.findById(id).get();
        }
        return null;
    }

    @Override
    public PaginationBean<CompanyContractEntity> findByPage(int currentPage, int pageSize) {
        PaginationBean paginationBean=new PaginationBean();

        Pageable pageable=new PageRequest((currentPage-1),pageSize);

        paginationBean.setCurrentPage(currentPage);
        paginationBean.setPageSize(pageSize);
        paginationBean.setDataList(companyContractDao.findByPage(pageable));
        int totalPage=0;

        if((companyContractDao.findByItemsCount().get(0).intValue())%pageSize!=0){
            totalPage=(companyContractDao.findByItemsCount().get(0).intValue())/pageSize+1;

        }else{
            totalPage=(companyContractDao.findByItemsCount().get(0).intValue())/pageSize;
        }

        paginationBean.setTotal(totalPage);
paginationBean.setCount(companyContractDao.findByItemsCount().get(0).intValue());

        paginationBean.setCount(companyContractDao.findByItemsCount().get(0).intValue());
        return paginationBean;

    }


}
