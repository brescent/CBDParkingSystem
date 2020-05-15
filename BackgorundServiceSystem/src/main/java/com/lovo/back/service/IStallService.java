package com.lovo.back.service;

import com.lovo.back.dao.IStallDao;
import com.lovo.back.entity.PaginationBean;
import com.lovo.back.entity.StallEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IStallService {

    /*企业用户查询平台空闲的车位*/
    public List<StallEntity> findByState();

    /*跟据 车位地址和编号进行动态查询*/
    public PaginationBean<StallEntity> findByItems(String stallAddress, String stallNo, int page, int size);

    /*修改车位的所属者身份证号*/
    public void updatePeopleNo(int id,String peopleNum);

    /*批量添加车位*/
    public  void add(String  stallAddress,String addressNo,int total,int startNum);

    /**
     *查询所有车位
     * @return
     */
    public List<StallEntity>  findAll
            ();




    /*批单个添加车位*/
    public  void addSingle(String  stallAddress,String stallNo,String peopleNo,String stallImg);



    /*审核车位信息*/


    public void updateValid(int id);

    /**
     * 查看所有未审核车位
     * @return 未审核车位信息集合
     */

    public List<StallEntity> findNoValid();


    /**
     * 根据用户身份证查询车位信息
     * @param peopleNo
     * @return
     */

    public StallEntity  findByPeopleNo(String peopleNo);


}
