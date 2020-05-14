package com.project.dao;

import com.project.entity.PowerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 权限持久接口
 */
public interface IPowerDao extends CrudRepository<PowerEntity,Integer> {

    /**
     * 根据管理员id获取对应的权限集合
     * @param adminId
     * @return 权限实体集合
     */
    @Query("from PowerEntity where admin.id=:adminId")
    public List<PowerEntity> getPowerByAdmidId(@Param("adminId") int adminId);

    /**
     * 根据管理员id删除对应管理员权限
     * @param adminId
     */
    @Query("delete  from PowerEntity where admin.id=?1")
    public void delPowerByAdminId(@Param("adminId") int adminId );
}
