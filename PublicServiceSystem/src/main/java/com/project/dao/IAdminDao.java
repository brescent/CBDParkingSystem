package com.project.dao;

import com.project.entity.AdminEntity;
import com.project.entity.PowerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAdminDao extends CrudRepository<AdminEntity,Integer> {

    @Query("from AdminEntity where publicUser.id=:userId")
    public AdminEntity getAdminEntityById(@Param("userId") int userId);

    @Query("from PowerEntity where admin.id=:adminId")
    public List<PowerEntity> getPowerByAdmidId(@Param("adminId") int adminId);

}
