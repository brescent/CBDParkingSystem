package com.project.Service;

import com.project.entity.AdminEntity;
import com.project.entity.PowerEntity;

import java.util.List;

/**
 * 权限业务接口
 */
public interface IPowerService {
    /**
     * 根据管理员id获取对应权限集合
     * @param adminId
     * @return 权限实体集合
     */
    public List<PowerEntity> getPowerByAdminId(int adminId);

    /**
     * 根据管理员id删除对应权限
     * @param adminId
     */
    public void delPowerByAdminId(int adminId);

    /**
     * 添加权限
     * @param power 权限实体
     */
    public void addPower(PowerEntity power);


}
