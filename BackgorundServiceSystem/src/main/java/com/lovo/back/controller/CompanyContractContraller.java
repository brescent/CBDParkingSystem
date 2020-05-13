package com.lovo.back.controller;


import com.lovo.back.entity.CompanyContractEntity;
import com.lovo.back.service.ICompanyContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyContractContraller {


    @Autowired
    ICompanyContractService companyCtractService;

    /**
     * 查询所有的企业合约
     * @return
     */
    @GetMapping("companyContract/findAll")
    public List<CompanyContractEntity> findAll(){


      return    companyCtractService.findAll();
    }


    /**
     * 根据id查看租户合约详情
     * @param id
     * @return
     */


    @GetMapping("companyContract/findById/{id}")
    public  CompanyContractEntity findById(@PathVariable("id")String  id){

        return companyCtractService.findById(Integer.parseInt(id)).get();

    }

    /**
     * 添加租户合约
     * @param companyCtractEntity  租户合约实体对象
     */
    @GetMapping("companyContract/add")
    public void  addCompanyContract(@RequestBody CompanyContractEntity companyCtractEntity){
           companyCtractService.add(companyCtractEntity);
    }

    /**
     * 租户合约解约  根据合同id修改合同失效状态
     * @param id
     */

    @GetMapping("companyContract/updateState/{id}")
    public void updateState(@PathVariable("id")String id){

        companyCtractService.updateState(Integer.parseInt(id));
    }



}
