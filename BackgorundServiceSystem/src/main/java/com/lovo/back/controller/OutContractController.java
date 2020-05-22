package com.lovo.back.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lovo.back.dto.OutContractDto;
import com.lovo.back.entity.CompanyContractEntity;
import com.lovo.back.entity.OutContractEntity;
import com.lovo.back.service.IOutContractService;
import com.lovo.back.service.impl.OutContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("outContract")
public class OutContractController {

    @Autowired
    IOutContractService contractService;
    /**
     * 查询所有的企业合约
     * @return
     */
    @GetMapping("findAll")
    public String findAll(){


        return JSON.toJSONString( contractService.findAll());
    }





    /**
     * 根据id查看租户合约详情
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public  String findById(@PathVariable("id")String  id){



        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        String str= JSON.toJSONString(contractService.findById(Integer.parseInt(id)), SerializerFeature.WriteDateUseDateFormat);
        return str;

    }

    /**
     * 添加租户合约
     * @param outContractEntity  租户合约实体对象
     */
    @PostMapping("add")
    public void  addOutContract(@RequestBody Map<String,Object> map){

        OutContractEntity out=new OutContractEntity();

        out.setOutContractNo((String)map.get("contractNo"));
        out.setUnit((String)map.get("unit"));
        out.setLinkMan((String)map.get("linkMan"));
        out.setBothParties((String)map.get("bothParties"));
        String str1=(String)map.get("startDate");

        str1=str1.substring(0,10);
        out.setStartDate(Date.valueOf(str1));

        String str2=(String)map.get("endDate");
        str2=str2.substring(0,10);
        out.setEndDate(Date.valueOf(str2));

        out.setDealPrice(Double.parseDouble((Integer)map.get("dealPrice")+""));
        out.setContractImg((String)map.get("contractImg"));
        out.setOldOutContractNo((String)map.get("oldContractNo"));

        contractService.add(out,(List<Integer>)map.get("stallIdList"));

    }

    /**
     * 租户合约解约  根据合同id修改合同失效状态
     * @param id
     */

    @GetMapping("updateState/{id}")
    public void updateState(@PathVariable("id")String id){

        contractService.updateState(Integer.parseInt(id));
    }

    @GetMapping("findByPage/{currentPage}/{pageSize}")
    public String findByPage(@PathVariable("currentPage")int currentPage,@PathVariable("pageSize")int pageSize){



        return JSON.toJSONString(contractService.findByPage(currentPage, pageSize));
    }

}
