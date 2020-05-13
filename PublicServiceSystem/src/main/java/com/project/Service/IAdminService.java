package com.project.Service;

import com.project.entity.AdminEntity;

import java.util.List;

/**
 * 管理员业务接口
 */
public interface IAdminService {
    /**
     * 添加管理员
     * @param admin 管理员实体
     */
    public  void addAdmin(AdminEntity admin);


    /**
     * 根据用户id查询对应管理员的详细信息
     * @param UserId 用户id'
     * @return 管理员实体
     */
    public AdminEntity getAdminEntityById(int UserId);

    /**
     * 查询所有管理员
     * @return 管理员实体集合
     */
    public List<AdminEntity> getAllAdmin();

    /**
     * 根据id删除管理员
     * @param adminId
     */
    public  void delAdmin(int adminId);


}
