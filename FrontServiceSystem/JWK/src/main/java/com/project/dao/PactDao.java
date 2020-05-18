package com.project.dao;


import com.project.entity.FrontPactEntity;
import org.springframework.data.repository.CrudRepository;

public interface PactDao extends CrudRepository<FrontPactEntity,Integer> {
}
