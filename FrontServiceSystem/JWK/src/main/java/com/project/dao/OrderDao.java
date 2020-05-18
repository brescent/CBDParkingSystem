package com.project.dao;

import com.project.entity.FrontOrderEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDao extends CrudRepository<FrontOrderEntity,Integer> {


    @Query(value = "SELECT *from  t_front_order as t WHERE  t.fk_front_user_info_id=?1",nativeQuery = true)
    public List<FrontOrderEntity> orderByUserid(int id);

}
