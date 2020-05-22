package com.lovo.back.dao;

import com.lovo.back.entity.CompanyContractAndStall;
import com.lovo.back.entity.OutContractAndStall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IOutContractAndStallDao extends CrudRepository<OutContractAndStall,Integer> {
}
