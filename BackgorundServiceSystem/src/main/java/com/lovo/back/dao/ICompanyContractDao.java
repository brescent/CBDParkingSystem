package com.lovo.back.dao;

import com.lovo.back.entity.CompanyContractEntity;

import com.lovo.back.entity.OutContractEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface ICompanyContractDao extends CrudRepository<CompanyContractEntity,Integer> {

    /**
     *  根据id修改合同状态
     * @param id
     */
    @Modifying
    @Query(value = "update CompanyContractEntity set state=0 where pk_id=:id")
    public void updateState(@Param("id") int id);

    /**
     * 续约合同  根据id修改新合同编号
     * @param id
     * @param oldContractNo
     * @param newContractNo
     */
    @Modifying
    @Query(value = "update CompanyContractEntity set contractNo=:newContractNo , oldContractNo=:oldContractNo where pk_id=:id",nativeQuery = true)
    public void updateContractNo(@Param("id")int  id,@Param("oldContractNo")String oldContractNo,@Param("newContractNo")String newContractNo);

    /**
     * 根据企业用户id查询所有 的 企业合同
     * @param id  企业id
     * @return 企业合同集合
     */
    @Query(value="select b.* from t_company as c,t_company_contract as b where c.pk_company_userid=b.company_id and pk_companyUserID=:id",nativeQuery = true)
    public List<CompanyContractEntity>  findByCompany(@Param("id")int  id);



    /*跟据 车位地址和编号进行动态查询*/
    @Query(value="select * from  t_company_contract "
            ,
            countQuery = " select count(*) from t_company_contract "+
                    " order by ?#{#pageable}",nativeQuery = true)
    public List<CompanyContractEntity> findByPage(Pageable pageable);

    @Query(value="select count(*) from t_company_contract ",
            nativeQuery = true)
    public List<BigInteger> findByItemsCount();

}
