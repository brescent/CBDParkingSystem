package com.lovo.back.controller;


import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lovo.back.dto.CompanyContractDto;
import com.lovo.back.dto.CompanyDto;
import com.lovo.back.entity.CompanyContractEntity;
import com.lovo.back.service.ICompanyContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("companyContract")
public class CompanyContractController {


    @Autowired
    ICompanyContractService companyCtractService;

    /**
     * 查询所有的企业合约
     * @return
     */
    @GetMapping("findAll")
    public List<CompanyContractEntity> findAll(){


      return    companyCtractService.findAll();
    }


    /**
     * 根据id查看租户合约详情
     * @param id
     * @return
     */


    @GetMapping("findById/{id}")
    public String findById(@PathVariable("id")String  id){




        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        String str= JSON.toJSONString(companyCtractService.findById(Integer.parseInt(id)), SerializerFeature.WriteDateUseDateFormat);
        return str;

    }

    /**
     * 添加租户合约
     * @param companyCtractEntity  租户合约实体对象
     */
    @PostMapping("add")
    public void  addCompanyContract(@RequestBody Map<String,Object> map){
     CompanyContractEntity com=new CompanyContractEntity();

     com.setContractNo((String) map.get("contractNo"));
     com.setDealPrice(Double.parseDouble((Integer)map.get("dealPrice")+""));




        String str1=(String)map.get("startDate");

        str1=str1.substring(0,10);
        com.setStartDate(Date.valueOf(str1));

        String str2=(String)map.get("endDate");
        str2=str2.substring(0,10);
        com.setEndDate(Date.valueOf(str2));

        com.setCompanyName((String) map.get("companyName"));
        com.setLinkMan((String) map.get("linkMan"));
        com.setPhone((String) map.get("phone"));

        com.setContractImg((String) map.get("contractImg"));

        com.setOldContractNo((String) map.get("oldContractNo"));
        companyCtractService.add(com, (List<Integer>) map.get("stallIdList"));

    }

    /**
     * 租户合约解约  根据合同id修改合同失效状态
     * @param id
     */

    @GetMapping("updateState/{id}")
    public void updateState(@PathVariable("id")String id){

        companyCtractService.updateState(Integer.parseInt(id));
    }

    @GetMapping("findByPage/{currentPage}/{pageSize}")
    public String findByPage(@PathVariable("currentPage") int currentPage,@PathVariable("pageSize") int pageSize){


        return JSON.toJSONString(companyCtractService.findByPage(currentPage, pageSize));
    }


}
