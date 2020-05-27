package com.test;
import	java.util.Calendar;



import com.lovo.back.BackMain;

import com.lovo.back.controller.CheckController;
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
    ICompanyContractService companyContractService;

@Autowired
CheckController c;

    @Test
    public void test1(){


       stallService.addSingle("问wong路888号","WW666","46484545348348","img1");

//        stallService.add("台南府二届","cw",5,3);


//        System.out.println(stallService.findByPeopleNo("51246587531596"));

//        stallService.updateValid(26);
        stallService.updatePeopleNo(24,"88888888888");


    }


    @Test
    public  void  testAddCompanyContract() {

        CompanyContractEntity com=new CompanyContractEntity("qqq555", Date.valueOf("2020-06-05"),Date.valueOf("2021-09-09")
        ,25648,"img1",null);


        //CompanyEntity  companyEntity=new CompanyEntity("咕咕鸡科技有限公司","黄花梨街32号","咕咕鸡","154875454");

      //companyDao.save(companyEntity);


      //  com.setCompany(companyDao.findById(3));
     //   companyContractService.add(com,new int[] {31,32,33});
    }

    @Test
    public  void test2(){

     PaginationBean<StallEntity> list=  stallService.findByItems("南",null,1,5);
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

        //outContractService.add(out,new int[]{17,19,21});


    }

    @Test
        public  void  testContract(){

        //System.out.println(outContractService.findById(2));
       // System.out.println(companyContractService.findById(4).getSet().iterator());

        //outContractService.updateState(1);
       // stallDao.updateState(17,0);

        //companyContractService.updateState(3);

       // System.out.println(stallDao.save(new StallEntity("天府二街永商cdb","TFcbd154","51246587531596","img1")));

//    for(StallEntity s:stallService.findAll()){
//        System.out.println(s.getStallAddress());
//    }

        //System.out.println(outContractService.findByPage(1,2).getDataList().get(0).getOutContractNo());

        //System.out.println(companyContractService.findByPage(1,1).getDataList().get(0).getDealPrice());

        //System.out.println(outContractService.findById(1).getOutContractAndStallSet().size());

//        System.out.println(stallService.findByAddress("").size());

//        Calendar calendar = Calendar.getInstance();


        System.out.println(companyContractService.findByPage(1,3).getDataList().get(1).toString());

    }


//    @Test
//    public  void  mq(){
//
//     c.updPartCheckType(1);
//
//
//    }
}
