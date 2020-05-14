package com.project.controller;

import com.project.Service.IAdminService;
import com.project.entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理员控制器
 */
@RestController
@RequestMapping("admin")
public class AdminfController {

    @Autowired
    private IAdminService adminService;


    /**
     * 添加管理员
     * @param admin
     * @param pwd
     */
    @RequestMapping("addAdmin")
    public void addAdmin(@RequestBody AdminEntity admin,@PathVariable("pwd")String pwd){
        adminService.addAdmin(admin,pwd);
    }

    /**
     * 获取所有管理员
     * @return
     */
    @RequestMapping("getAllAdmin")
    public List<AdminEntity> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    /**
     * 根据用户id查询对应管理员信息
     * @param userId
     * @return
     */
    @RequestMapping("getAdminByUserId")
    public AdminEntity getAdminByUserId(@PathVariable("userId")int userId){
        return adminService.getAdminEntityByUserId(userId);
    }

    /**
     * 根据管理员id查询管理员
     * @param adminId
     * @return
     */
    @RequestMapping("getAdminById")
    public AdminEntity getAdminById(@PathVariable("adminId")int adminId){
        return adminService.getAdminById(adminId);
    }

    /**
     * 根据id删除管理员
     * @param adminId
     */
    @RequestMapping("delAdmin")
    public  void delAdmin(@PathVariable("adminId")int adminId){
        adminService.delAdmin(adminId);
    }

    /**
     * 根据id修改管理员权限
     * @param adminId 管理员id
     * @param newPower 新权限数组
     */
    public void updAdminPower(@PathVariable("adminId")int adminId,@PathVariable("newPower")int[] newPower){

    }
}
