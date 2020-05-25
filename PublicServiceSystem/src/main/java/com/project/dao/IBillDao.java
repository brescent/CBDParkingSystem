package com.project.dao;

import com.project.entity.BillEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * 账单持久层接口
 */
public interface IBillDao extends CrudRepository<BillEntity,Integer> {

    /**
     * 动态查询账单
     * @param userId    用户id
     * @param startDate 起始日期
     * @param endDate   终止日期
//     * @param pageSize  每页条数
//     * @param pageNum   页码
     * @return  账单分页对象
     */
    @Query(value = " select * from  t_bill where 1=1 and if( :startDate != '',b_trade_date > :startDate , 1=1) and if( :endDate != '',b_trade_date < :endDate , 1=1) and fk_user_id = :userId ",
            countQuery = " select count(1) from  t_bill where 1=1 and if( :startDate = '', b_trade_date > :startDate , 1=1) and if( :endDate = '',b_trade_date < :endDate , 1=1) and fk_user_id = :userId ",
            nativeQuery = true)
    public Page<BillEntity> findByItem(@Param("userId") int userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

    /**
     * 通过id查询账单
     * @param billId 账单id
     * @return 账单实体
     */
    @Query("from BillEntity where billId = :billId")
    public BillEntity findById(@Param("billId") int billId);

//    /**
//     * 添加账单
//     * @param billEntity 账单实体
//     */
//    public void addBill(BillEntity billEntity);
}
