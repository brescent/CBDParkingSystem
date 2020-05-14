package com.lovo.back.dao;

import com.lovo.back.entity.CompanyContractEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ICompanyContractDao extends CrudRepository<CompanyContractEntity,Integer> {


    @Query(value = "update CompanyContractEntity set state=0")
    public void updateState(int id);



}
