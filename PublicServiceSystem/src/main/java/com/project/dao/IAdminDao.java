package com.project.dao;

import com.project.entity.AdminEntity;
import com.project.entity.PageEntity;
import com.project.entity.PowerEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.swing.*;
import java.awt.print.Pageable;
import java.util.List;

/**
 * 管理员持久接口
 */
public interface IAdminDao extends CrudRepository<AdminEntity,Integer> {

    /**
     * 根据用户di查询对应管理员的详细信息
     * @param userId
     * @return
     */
    @Query("from AdminEntity where publicUser.id=:userId")
    public AdminEntity getAdminEntityById(@Param("userId") int userId);

    /**
     * 分页查询所有管理员
     * @param pageable 分页查询对象
     * @return 分页数据集合
     */
    @Query(value = "from AdminEntity ")
    public List<AdminEntity> getAllAdmin(PageRequest pageable);

    /**
     * 查询管理员数据条数
     * @return
     */
    @Query( "select count (id) from  AdminEntity " )
    public int getAdminCount();


    @Query(value = "from  AdminEntity  where id=:adminId")
    public AdminEntity findAdminByAdminId(@Param("adminId") int admindId);



}
