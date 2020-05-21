package com.project.service;

import com.project.vo.CompanyVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * web企业业务接口
 */
@FeignClient("publicUserService")
public interface IWebCompanyService {


    /**
     * 添加新企业
     * @param company
     */
    @RequestMapping("/addCompany")
    public void addCompany(@RequestBody CompanyVo company);


    /**
     * 获取所有企业
     * @return
     */
    @PostMapping("/getAllCompany")
    public String getAllCompany( @RequestBody Map map);
    /**
     * 恩据id删除企业
     * @param companyId
     */
    @DeleteMapping("/delCompany/{companyId}")
    public  String delCompany(@PathVariable("companyId") int companyId);

    /**
     * 根据用户id获取对应的企业用户详情
     * @param userId
     * @return
     */
    @RequestMapping("/getCompanyByUserId")
    public String getCompanyByUserId(@PathVariable("userId") int userId);


    /**
     * 根据id查询企业
     * @param companyId
     * @return
     */
    @RequestMapping("/getCompanyById/{companyId}")
    public String getCompanyById(@PathVariable("companyId") int companyId);
}
