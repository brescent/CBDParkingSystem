package com.project.controller;

import com.project.entity.AdminEntity;
import com.project.entity.PageEntity;
import com.project.service.IWebAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员控制器
 */
@RestController
public class WebAdminfController {

    @Autowired
    private IWebAdminService webAdminService;



    /**
     * 获取所有管理员
     *
     * @return
     */
    @GetMapping("getAllAdmin")
    public String getAllAdmin(int pageNum, int pageSize) {

        System.out.println();
        return webAdminService.getAllAdmin(pageNum, pageSize);


    }


    /**
     * 添加管理员
     *
     * @param admin
     * @param pwd
     */
    @RequestMapping("addAdmin")
    public void addAdmin( AdminEntity admin,  String pwd) {
        webAdminService.addAdmin(admin, pwd);
    }


    /**
     * 根据用户id查询对应管理员信息
     *
     * @param userId
     * @return
     */
    @RequestMapping("getAdminByUserId")
    public AdminEntity getAdminByUserId(@PathVariable("userId") int userId) {
        return webAdminService.getAdminByUserId(userId);
    }

    /**
     * 根据管理员id查询管理员
     *
     * @param adminId
     * @return
     */
    @RequestMapping("getAdminById")
    public AdminEntity getAdminById(@PathVariable("adminId") int adminId) {
        return webAdminService.getAdminById(adminId);
    }

    /**
     * 根据id删除管理员
     *
     * @param adminId
     */
    @RequestMapping("delAdmin")
    public void delAdmin(@PathVariable("adminId") int adminId) {
        webAdminService.delAdmin(adminId);

    }

    /**
     * 根据id修改管理员权限
     *
     * @param adminId  管理员id
     * @param newPower 新权限数组
     */
    @RequestMapping("updAdmin")
    public void updAdminPower(@PathVariable("adminId") int adminId, @PathVariable("newPower") int[] newPower) {

    }
}
