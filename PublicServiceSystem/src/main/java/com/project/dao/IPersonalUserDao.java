package com.project.dao;

import com.project.entity.PersonalUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IPersonalUserDao extends CrudRepository<PersonalUserEntity,String> {


    /**
     * 根据用户id，查询个人用户详情
     * @param userId 用户id
     * @return个人用户对象
     */
    @Query("from  PersonalUserEntity  where publicUser.id=:userId")
    public PersonalUserEntity getPersonalUser(@Param("userId") int userId);


    /**
     * 根据id修改个人用户信息
     * @param email
     * @param jobInfo
     * @param homeAddress
     * @param phone
     * @param userId
     */
    @Query("update PersonalUserEntity set email=:email,jobInfo=:jobInfo ,homeAddress=:homeAddress,phone=:phone where id=:userId")
    public void updatePersonalUser(@Param("email") String email, @Param("jobInfo")
            String jobInfo, @Param("homeAddress")
                                           String homeAddress, @Param("phone")
                                           String phone, @Param("userId") int userId);
}
