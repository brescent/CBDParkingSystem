package com.project.controller;

import com.project.Service.IAdminService;
import com.project.dto.AdminVo;
import com.project.entity.AdminEntity;
import com.project.entity.PageEntity;
import com.project.entity.PowerEntity;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.GET;
import java.util.List;

/**
 * 管理员控制器
 */
@RestController
public class AdminfController {

    @Autowired
    private IAdminService adminService;

    /**
     * 获取所有管理员
     *
     * @return
     */
    @GetMapping("getAllAdmin/{pageNum}/{pageSize}")
    public String getAllAdmin(
            @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {

        PageEntity<AdminEntity> pageEntity = adminService.getAllAdmin(pageNum, pageSize);

        //将对象转化成json字符串
        String json = JSON.toJSONString(pageEntity);


        return json;
    }


    /**
     * 添加管理员
     *
     * @param admin
     * @param
     */
    @PostMapping("addAdmin")
    public String addAdmin(@RequestBody AdminVo admin) {
        return adminService.addAdmin(admin);
    }

    /**
     * 根据管理员id查询管理员
     *
     * @param adminId
     * @return
     */
    @GetMapping("getAdminById/{adminId}")
    public String getAdminById(@PathVariable("adminId") int adminId) {
        AdminEntity adminEntity = adminService.getAdminById(adminId);
        //获取权限集合
        List pl = adminEntity.getPowerList();
        //创建一个长度为权限几个长度的数组
        int[] powerInfoArray = new int[pl.size()];
        //循环权限数组
        for (int i = 0; i < pl.size(); i++) {
            PowerEntity powerEntity = (PowerEntity) pl.get(i);
            powerInfoArray[i] = powerEntity.getPowerInfo();
        }
        //将数据放进adminvo中
        AdminVo adminVo = new AdminVo();
        adminVo.setId(adminEntity.getId());
        adminVo.setJobNum(adminEntity.getJobNum());
        adminVo.setRealName(adminEntity.getRealName());
        adminVo.setPhone(adminEntity.getPhone());
        adminVo.setPowerList(powerInfoArray);
        //将对象转化成json字符串
        String json = JSON.toJSONString(adminVo);
        return json;
    }

    /**
     * 修改管理员权限
     *
     * @param adminId
     * @param powerList
     */
    @PostMapping("updAdmin")
    public String updAdminPower(@RequestParam("adminId") Integer adminId, @RequestParam("powerList") int[] powerList) {


        return adminService.updAdminPower(adminId, powerList);


    }

    /**
     * 根据用户id查询对应管理员信息
     *
     * @param userId
     * @return
     */
    @RequestMapping("getAdminByUserId")
    public AdminEntity getAdminByUserId(@PathVariable("userId") int userId) {
        return adminService.getAdminEntityByUserId(userId);
    }

    /**
     * 根据id删除管理员
     *
     * @param adminId
     */
    @RequestMapping("delAdmin/{adminId}")
    public String delAdmin(@PathVariable("adminId") int adminId) {
       return adminService.delAdmin(adminId);
    }


}
