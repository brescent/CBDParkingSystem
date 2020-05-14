package com.project.dao;

import com.project.entity.CompanyUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * 企业用户持久接口
 */
public interface ICompanyDao extends CrudRepository<CompanyUserEntity,Integer> {
     /**
     * 根据id修改企业用户详情
     * @param contact
     * @param contactPhone
     */
    @Query("update CompanyUserEntity set contact=:contact,contactPhone=:contactPhone where id=:userId")
    public void updateCompanyUser(@Param("contact") String contact, @Param("contactPhone") String contactPhone, @Param("userId") int userID);


    /**
     * 根据用户id查询对应的企业用户详情
     * @param userId
     * @return 企业实体
     */
    @Query("from CompanyUserEntity where publicUser.id=:userId")
    public CompanyUserEntity getCompanyUserById(@Param("userId") int userId);
}
