package com.project.service;

import com.project.vo.CompanyVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @PostMapping("/addCompany")
    public String addCompany(@RequestBody CompanyVo company);


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
     * 根据id查询企业
     * @param companyId
     * @return
     */
    @RequestMapping("/getCompanyById/{companyId}")
    public String getCompanyById(@PathVariable("companyId") int companyId);

    /**
     * 根据用户id查询对应企业详情
     * @param userId
     * @return
     */
    @RequestMapping("/getCompanyByUserId/{userId}")
    public String getCompanyByUserId(@PathVariable("userId")Integer userId);
    /**
     * 修改企业用户信息
     * @param map 新数据
     * @return
     */
    @RequestMapping("/updCompany")
    public  String updCompany(@RequestBody Map<String,Object> map);
}
