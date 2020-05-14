package com.project.controller;

import com.project.Service.ICompanyUserService;
import com.project.entity.CompanyUserEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 企业用户控制器
 */
@RestController
@RequestMapping("company")
public class CompanyController {

    private ICompanyUserService companyUserService;

    /**
     * 添加新企业
     * @param company
     */
    @RequestMapping("addCompany")
    public void addCompany(@RequestBody CompanyUserEntity company,
                           @PathVariable("companyLoginName")String companyLoginName,
                           @PathVariable("companyLoginpwd")String companyLoginPwd){
        companyUserService.addCompany(company,companyLoginName,companyLoginPwd);
    }

    /**
     * 获取所有企业
     * @return
     */
    @RequestMapping("getAllCompany")
    public List<CompanyUserEntity> getAllCompany(){

        return companyUserService.getAllCompany();
    }

    /**
     * 恩据id删除企业
     * @param companyId
     */
    @RequestMapping("delCompany")
    public  void delCompany(@PathVariable("companyId")int companyId){
        companyUserService.delCompany( companyId);
    }

    /**
     * 根据用户id获取对应的企业用户详情
     * @param userId
     * @return
     */
    @RequestMapping("getCompanyByUserId")
    public CompanyUserEntity getCompanyByUserId(@PathVariable("userId")int userId){
       return companyUserService.getCompanyUserById(userId);
    }

    /**
     * 根据id查询企业
     * @param companyId
     * @return
     */
    @RequestMapping("getCompanyById")
    public CompanyUserEntity getCompanyById(@PathVariable("companyId")int companyId){
        return companyUserService.getCompanyById(companyId);
    }
}
