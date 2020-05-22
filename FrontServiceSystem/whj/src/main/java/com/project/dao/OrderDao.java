package com.project.dao;

import com.project.entity.FrontOrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<FrontOrderEntity,Integer> {
}
