package com.lovo.back.service;

import com.lovo.back.dao.IStallDao;
import com.lovo.back.entity.StallEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStallService {

    /*企业用户查询平台空闲的车位*/
    public List<StallEntity> findByState();

    /*跟据 车位地址和编号进行动态查询*/
    public List<StallEntity>  findByItems(String stallAddress, String stallNo, int page,int size);

    /*修改车位的所属者身份证号*/
    public void updatePeopleNo(int id,String peopleNum);

    /*添加车位*/
    public  void add(String  stallAddress,String addressNo,int total,int startNum);

    public List<StallEntity>  findAll
            ();
 }
