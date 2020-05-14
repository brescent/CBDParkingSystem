package com.lovo.back.dao;

import com.lovo.back.entity.OutContractEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOutContractDao extends CrudRepository<OutContractEntity,Integer> {


    @Query(value = "update OutContractEntity set state=0 where pk_id=?1")
      public void updateState(int id);


    /**
     * 续约合同  根据id修改新合同编号
     * @param id
     * @param oldContractNo
     * @param newContractNo
     */
    @Modifying
    @Query(value = "update CompanyContractEntity set contractNo=?3,oldContractNo=?2 where pk_id=?1")
    public void updateContractNo(int  id,String oldContractNo,String newContractNo);


}
