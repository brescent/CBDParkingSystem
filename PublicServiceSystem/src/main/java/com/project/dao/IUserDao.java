package com.project.dao;

import com.project.entity.PublicUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**用户持久层*/
public interface IUserDao extends CrudRepository<PublicUserEntity,Integer> {

    /**
     * 用户登录，再根据用户类型到属于他角色的表查询角色详情
     * @param userName 用户名
     * @param pwd 密码
     * @return 用户对象
     */
    @Query("from PublicUserEntity  where loginName=:userName and pwd=:pwd")
    public PublicUserEntity login(@Param("userName") String userName, @Param("pwd") String pwd);




    @Query("from PublicUserEntity  where loginName=:userName")
    public PublicUserEntity findUserByName(@Param("userName") String userName);



}
