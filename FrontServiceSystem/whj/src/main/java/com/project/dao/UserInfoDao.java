package com.project.dao;

import com.project.entity.FrontUserInfoEntity;
import org.springframework.data.repository.CrudRepository;

public  interface   UserInfoDao extends CrudRepository<FrontUserInfoEntity,Integer> {
}
