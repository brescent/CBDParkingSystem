package com.lovo.back.controller;


import com.lovo.back.entity.CompanyContractEntity;
import com.lovo.back.entity.OutContractEntity;
import com.lovo.back.service.IOutContractService;
import com.lovo.back.service.impl.OutContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutContractContraller {

    @Autowired
    IOutContractService contractService;
    /**
     * 查询所有的企业合约
     * @return
     */
    @GetMapping("outContract/findAll")
    public List<OutContractEntity> findAll(){


        return    contractService.findAll();
    }


    /**
     * 根据id查看租户合约详情
     * @param id
     * @return
     */
    @GetMapping("outContract/findById/{id}")
    public  OutContractEntity findById(@PathVariable("id")String  id){

        return contractService.findById(Integer.parseInt(id)).get();

    }

    /**
     * 添加租户合约
     * @param outContractEntity  租户合约实体对象
     */
    @GetMapping("outContract/add")
    public void  addCompanyContract(@RequestBody OutContractEntity outContractEntity){
        contractService.add(outContractEntity);
    }

    /**
     * 租户合约解约  根据合同id修改合同失效状态
     * @param id
     */

    @GetMapping("outContract/updateState/{id}")
    public void updateState(@PathVariable("id")String id){

        contractService.updateState(Integer.parseInt(id));
    }

}
