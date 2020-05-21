package com.project.Service;

import com.project.dto.AdminVo;
import com.project.entity.AdminEntity;
import com.project.entity.PageEntity;
import org.omg.CORBA.StringHolder;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 管理员业务接口
 */
public interface IAdminService {
    /**
     * 添加管理员
     *
     * @param admin 管理员vo
     */
    public String addAdmin(AdminVo admin);


    /**
     * 根据用户id查询对应管理员的详细信息
     *
     * @param UserId 用户id'
     * @return 管理员实体
     */
    public AdminEntity getAdminEntityByUserId(int UserId);


    /**
     * 根据管理员id查询管理员
     * @param adminId
     * @return 管理员实体
     */
    public AdminEntity getAdminById(int adminId);

    /**
     * 动态查询所有管理员
     * @param pageNum 当前页码
     * @param pageSize 每页显示条数
     * @return 数据集合
     */
    public PageEntity<AdminEntity> getAllAdmin(int pageNum, int pageSize);

    /**
     * 根据id删除管理员
     *
     * @param adminId
     */
    public String delAdmin(int adminId);

    /**
     * 根据管理员id修改权限
     * @param adminId 管理员id
     * @param newPower 新权限数组
     */
    public String updAdminPower(int adminId, int[] newPower);

}
