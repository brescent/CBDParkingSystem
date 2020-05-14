package com.lovo.back.dao;

import com.lovo.back.entity.CompanyContractAndStall;
import com.lovo.back.entity.OutContractAndStall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOutContractAndStallDao extends CrudRepository<OutContractAndStall,Integer> {
}
