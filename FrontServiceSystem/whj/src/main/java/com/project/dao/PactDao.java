package com.project.dao;

import com.project.entity.FrontPactEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * 合同持久层
 */
public interface PactDao extends CrudRepository<FrontPactEntity,Integer> {
}
