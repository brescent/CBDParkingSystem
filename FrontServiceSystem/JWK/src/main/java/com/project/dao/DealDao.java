package com.project.dao;

import com.project.entity.FrontDealEntity;
import org.springframework.data.repository.CrudRepository;

public interface DealDao extends CrudRepository<FrontDealEntity ,Integer> {
}
