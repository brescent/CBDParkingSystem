package com.project.dao;

import com.project.entity.PowerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPowerDao extends CrudRepository<PowerEntity,Integer> {
    @Query("from PowerEntity where admin.id=:adminId")
    public List<PowerEntity> getPowerByAdmidId(@Param("adminId") int adminId);
}
