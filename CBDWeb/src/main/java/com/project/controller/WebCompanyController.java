package com.project.controller;


import com.project.entity.CompanyUserEntity;
import com.project.entity.PageEntity;
import com.project.service.IWebCompanyService;
import com.project.vo.CompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 企业用户控制器
 */
@RestController
public class WebCompanyController {

    @Autowired
    private IWebCompanyService companyUserService;

    /**
     * 添加新企业
     *
     * @param company
     */
    @RequestMapping("addCompany")
    public void addCompany(@RequestBody CompanyVo company) {
        companyUserService.addCompany(company);
    }

    /**
     * 获取所有企业
     *
     * @return
     */
    @GetMapping("getAllCompany")
    public String getAllCompany(String companyName,
                                String companyAddress,
                                String contact,
                                String contactPhone,
                                Integer pageNum,
                                Integer pageSize) {
        Map map = new HashMap();
        map.put("companyName", companyName);
        map.put("companyAddress", companyAddress);
        map.put("contact", contact);
        map.put("contactPhone", contactPhone);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);

        String string =  companyUserService.getAllCompany(map);

        return string;
    }

    /**
     * 恩据id删除企业
     *
     * @param companyId
     */
    @GetMapping("delCompany")
    public String delCompany(int companyId) {

        return companyUserService.delCompany(companyId);
    }


    /**
     * 根据id查询企业
     *
     * @param companyId
     * @return
     */
    @RequestMapping("getCompanyById")
    public String getCompanyById(int companyId) {
        return companyUserService.getCompanyById(companyId);
    }
}
