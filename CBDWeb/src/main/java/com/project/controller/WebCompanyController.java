package com.project.controller;


import com.project.dto.UserDto;
import com.project.entity.CompanyUserEntity;
import com.project.entity.PageEntity;
import com.project.service.IWebCompanyService;
import com.project.vo.CompanyVo;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @PostMapping("addCompany")
    public String addCompany(@RequestBody CompanyVo company) {
      return   companyUserService.addCompany(company);
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
     * 跟据id删除企业
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

    /**
     * 根据用户id查询对应企业详情
     * @param request
     * @return
     */
    @GetMapping("getCompanyByUserId")
    public String getCompanyByUserId(HttpServletRequest request){

        UserDto user =(UserDto) request.getSession().getAttribute("user");

        String s = companyUserService.getCompanyByUserId(user.getId());
        return companyUserService.getCompanyByUserId(user.getId());
    }

    /**
     * 修改企业用户信息
     * @param map 新数据
     * @param request
     * @return
     */
    @PostMapping("updCompany")
    public  String updCompany(@RequestBody Map<String,Object> map,HttpServletRequest request){
        UserDto user =(UserDto) request.getSession().getAttribute("user");
        map.put("userId",user.getId());
        String s = companyUserService.updCompany(map);
        return s;
    }
}
