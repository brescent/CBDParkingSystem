package com.project.service;

import com.project.entity.AdminEntity;
import com.project.vo.AdminVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("publicUserService")
public interface IWebAdminService {
    /**
     * 获取所有管理员
     * @return
     */
    @GetMapping("/getAllAdmin/{pageNum}/{pageSize}")
    public String getAllAdmin(
            @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize);
    /**
     * 添加管理员
     * @param admin
     * @param
     */
    @PostMapping("/addAdmin")
    public String addAdmin(AdminVo admin);
    /**
     * 根据管理员id查询管理员
     * @param adminId
     * @return
     */
    @GetMapping("/getAdminById/{adminId}")
    public String getAdminById(@PathVariable("adminId")int adminId);
    /**
     * 根据id修改管理员权限
     * @param adminId 管理员id
     * @param powerList 新权限数组
     */
    @PostMapping("/updAdmin")
    public String updAdminPower(@RequestParam("adminId")Integer adminId,@RequestParam("powerList") int[] powerList);
    /**
     * 根据用户id查询对应管理员信息
     * @param userId
     * @return
     */
    @GetMapping("/getAdminByUserId")
    public String getAdminByUserId(@PathVariable("userId")int userId);



    /**
     * 根据id删除管理员
     * @param adminId
     */
    @GetMapping("/delAdmin/{adminId}")
    public  String delAdmin(@PathVariable("adminId")int adminId);


}
