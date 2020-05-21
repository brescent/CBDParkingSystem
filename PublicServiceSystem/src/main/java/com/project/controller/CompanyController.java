package com.project.controller;


import com.project.Service.ICompanyUserService;
import com.project.dto.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 企业用户控制器
 */
@RestController
public class CompanyController {

    @Autowired
    private ICompanyUserService companyUserService;

    /**
     * 添加新企业
     * @param company
     */
    @RequestMapping("addCompany")
    public void addCompany(@RequestBody CompanyDto company){
        companyUserService.addCompany(company);
    }

    /**
     * 获取所有企业
     * @return
     */
    @PostMapping("getAllCompany")
    public String getAllCompany(@RequestBody Map map){

        String companyName = (String) map.get("companyName");
        String companyAddress = (String) map.get("companyAddress");
        String contact = (String) map.get("contact");
        String contactPhone = (String) map.get("contactPhone");
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");

        return companyUserService.getAllCompany(
                companyName,companyAddress,contact,contactPhone,pageNum,pageSize);
    }

    /**
     * 恩据id删除企业
     * @param companyId
     */
    @DeleteMapping("delCompany/{companyId}")
    public  String delCompany(@PathVariable("companyId")int companyId){

        return  companyUserService.delCompany( companyId);
    }



    /**
     * 根据id查询企业
     * @param companyId
     * @return
     */
    @RequestMapping("getCompanyById/{companyId}")
    public String getCompanyById(@PathVariable("companyId")int companyId){
        return companyUserService.getCompanyById(companyId);
    }
}
