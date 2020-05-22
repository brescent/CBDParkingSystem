package com.project.service;


import com.project.dto.CompanyContractDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("backServerClient")
public interface ICompanyContractService {


    @GetMapping("companyContract/findByPage/{currentPage}/{pageSize}")
    public String findAllCompanyContract(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize);

    /**
     * 根据id查看租户合约详情
     * @param id
     * @return
     */


    @GetMapping("companyContract/findById/{id}")
    public String findById(@RequestParam("id")String  id);

    /**
     * 添加租户合约
     * @param companyCtractEntity  租户合约实体对象
     */
    @GetMapping("companyContract/add")
    public void  addCompanyContract( @RequestBody Map<String,Object> map);
    /**
     * 租户合约解约  根据合同id修改合同失效状态
     * @param id
     */

    @GetMapping("companyContract/updateState/{id}")
    public void updateState(@PathVariable("id")String id);



}
