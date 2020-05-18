package com.project.dao;

import com.project.entity.FrontcomplaintEntity;

import org.springframework.data.repository.CrudRepository;

public interface ComplaintDao  extends CrudRepository<FrontcomplaintEntity,Integer> {


}
