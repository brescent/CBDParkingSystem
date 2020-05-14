package com.project.dao;

import com.project.entity.PersonalUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IPersonalUserDao extends CrudRepository<PersonalUserEntity,Integer> {


    /**
     * 根据用户id，查询个人用户详情
     * @param userId 用户id
     * @return个人用户对象
     */
    @Query("from  PersonalUserEntity  where publicUser.id=:userId")
    public PersonalUserEntity getPersonalUser(@Param("userId") int userId);



}
