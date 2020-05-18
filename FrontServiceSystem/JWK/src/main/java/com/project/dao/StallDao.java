package com.project.dao;


import com.project.entity.FrontStallEntity;
import org.springframework.data.repository.CrudRepository;

public interface StallDao extends CrudRepository<FrontStallEntity,Integer> {
}
