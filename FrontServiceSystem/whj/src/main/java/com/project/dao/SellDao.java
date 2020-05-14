package com.project.dao;

import com.project.entity.frontStallEntity;
import org.springframework.data.repository.CrudRepository;

public interface SellDao extends CrudRepository<frontStallEntity,Integer> {
}
