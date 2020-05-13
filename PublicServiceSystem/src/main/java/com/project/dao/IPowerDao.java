package com.project.dao;

import com.project.entity.PowerEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPowerDao extends CrudRepository<PowerEntity,Integer> {
}
