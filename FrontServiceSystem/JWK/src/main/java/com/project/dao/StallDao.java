package com.project.dao;


import com.project.entity.FrontStallEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StallDao extends CrudRepository<FrontStallEntity,Integer> {

    @Query(value = "SELECT * from t_front_stall AS ts WHERE ts.fk_front_user_id=?1",nativeQuery = true)
    public List<FrontStallEntity> getStallByUserId(int id);

}
