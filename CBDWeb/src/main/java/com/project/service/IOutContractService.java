package com.project.service;


import com.project.dto.StallDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("backServerClient")
public interface IOutContractService {


    @GetMapping("outContract/findByPage/{currentPage}/{pageSize}")
    public String findAllOutContract(@PathVariable("currentPage")int currentPage,@PathVariable("pageSize")int pageSize);


    /**
     * 根据id查看租户合约详情
     * @param id
     * @return
     */
    @GetMapping("outContract/findById/{id}")
    public  String findById(@RequestParam("id") String  id);

    /**
     * 添加租户合约
     * @param
     */
    @PostMapping("outContract/add")
    public void  addCompanyContract(@RequestBody Map<String,Object> map);

    /**
     * 租户合约解约  根据合同id修改合同失效状态
     * @param id
     */

    @GetMapping("outContract/updateState/{id}")
    public void updateState(@PathVariable("id")String id);




}
