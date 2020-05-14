package com.lovo.back.dao;

import com.lovo.back.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICompanyDao extends CrudRepository<CompanyEntity,Integer> {
}
