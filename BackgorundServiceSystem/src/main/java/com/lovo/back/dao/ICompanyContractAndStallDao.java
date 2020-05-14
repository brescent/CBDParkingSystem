package com.lovo.back.dao;

import com.lovo.back.entity.CompanyContractAndStall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyContractAndStallDao extends CrudRepository<CompanyContractAndStall,Integer> {
}
