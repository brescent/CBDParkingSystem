package com.test;



import com.lovo.back.BackMain;
import com.lovo.back.dao.ICompanyDao;
import com.lovo.back.dao.IStallDao;
import com.lovo.back.entity.*;
import com.lovo.back.service.ICompanyContractService;
import com.lovo.back.service.IOutContractService;
import com.lovo.back.service.IStallService;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BackMain.class)
public class test {

    @Autowired
    IStallService stallService;
@Autowired
IStallDao   stallDao;

    @Autowired
    IOutContractService outContractService;
    @Autowired
    ICompanyDao companyDao;
    @Autowired
    ICompanyContractService companyContractService;


    @Test
    public void test1(){


//        stallService.addSingle("天府二街永商cdb","TFcbd154","51246587531596","img1");

//        stallService.add("台南府二届","cw",5,3);


//        System.out.println(stallService.findByPeopleNo("51246587531596"));

//        stallService.updateValid(26);
        stallService.updatePeopleNo(24,"88888888888");


    }


    @Test
    public  void  testAddCompanyContract() {

        CompanyContractEntity com=new CompanyContractEntity("tsdwa5454", Date.valueOf("2020-06-05"),Date.valueOf("2021-09-09")
        ,25648,"img1",null);


        //CompanyEntity  companyEntity=new CompanyEntity("战地干科技有限公司","黄花梨街48号","战地干","154875454");




        com.setCompany(companyDao.findById(2));

        companyContractService.add(com,new int[] {1,2,5,6});
    }

    @Test
    public  void test2(){

     PaginationBean<StallEntity> list=  stallService.findByItems("台",null,2,5);

        System.out.println(list.getTotal());

        for(StallEntity s:list.getDataList()){

            System.out.println(s.getStallNo()   +s.getId());

        }


//        int  total=stallDao.findByItemsCount("台",null).get(0).intValue();
//        System.out.println(total);
    }

    @Test
    public void addOutContract() {

        OutContractEntity  out=new OutContractEntity("5454dw","天空一号","张三","李四",Date.valueOf("2020-03-09"),Date.valueOf("2022-03-09"),5465,"contractImg",null);

        outContractService.add(out,new int[]{17,19,21});


    }

    @Test
    public  void  testContract(){
        System.out.println(outContractService.findById(1));
    }
}
