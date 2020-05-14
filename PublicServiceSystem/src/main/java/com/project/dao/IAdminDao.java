package com.project.dao;

import com.project.entity.AdminEntity;
import com.project.entity.PowerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAdminDao extends CrudRepository<AdminEntity,Integer> {
    /**
     * 根据用户di查询对应管理员的详细信息
     * @param userId
     * @return
     */
    @Query("from AdminEntity where publicUser.id=:userId")
    public AdminEntity getAdminEntityById(@Param("userId") int userId);



}
