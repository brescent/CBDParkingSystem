package com.project.controller;

import com.project.dto.UserDto;

import com.project.entity.PowerEntity;
import com.project.vo.AdminVo;
import com.project.service.IWebAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 管理员控制器
 */
@RestController
public class WebAdminfController {
    @Autowired
    private IWebAdminService webAdminService;
    /**
     * 获取所有管理员
     * @return
     */
    @GetMapping("getAllAdmin")
    public String getAllAdmin(int pageNum, int pageSize) {
       String str =  webAdminService.getAllAdmin(pageNum, pageSize);
        return webAdminService.getAllAdmin(pageNum, pageSize);
    }
    /**
     * 添加管理员
     * @param admin
     */
    @PostMapping("addAdmin")
    public String addAdmin(@RequestBody AdminVo admin) {
      return   webAdminService.addAdmin(admin);
    }

    /**
     * 修改管理员的个人信息
     * @param admin
     * @return
     */
    @PostMapping("updAdminMsg")
    public String updAdminMsg(@RequestBody AdminVo admin,HttpServletRequest request){
        UserDto user =(UserDto) request.getSession().getAttribute("user");
        String str = webAdminService.updAdminMsg(admin,user.getId());
        return   webAdminService.updAdminMsg(admin,user.getId());
    }
    /**
     * 根据管理员id查询管理员
     * @param adminId
     * @return
     */
    @GetMapping("getAdminById")
    public String getAdminById(int adminId) {
        return webAdminService.getAdminById(adminId);
    }

    /**
     * 根据用户id查询管理员信息
     * @param request
     * @return
     */
    @GetMapping("getAdminByUserId")
    public String getAdminByUserId(HttpServletRequest request){
        UserDto user =(UserDto) request.getSession().getAttribute("user");
        String string = webAdminService.getAdminByUserId(user.getId());
        return string;
    }
    /**
     * 根据id修改管理员权限
     * @param adminId  管理员id
     * @param powerList 新权限数组
     */
    @PostMapping("updAdmin")
    public String updAdminPower( int adminId, int[] powerList) {
        return webAdminService.updAdminPower(adminId,powerList);
    }




    /**
     * 根据id删除管理员
     *
     * @param adminId
     */
    @GetMapping("delAdmin")
    public String delAdmin(int adminId) {

        String ret = webAdminService.delAdmin(adminId);
       return  ret;

    }



}
