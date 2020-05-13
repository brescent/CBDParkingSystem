package com.lovo.back.dao;

import com.lovo.back.entity.OutContractEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IOutContractDao extends CrudRepository<OutContractEntity,Integer> {


    @Query(value = "update OutContractEntity set state=0")
public void updateState(int id);



}
