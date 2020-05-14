package com.project.dao;

import com.project.entity.BillEntity;
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
     * @param startDate 起始日期
     * @param endDate   终止日期
     * @return  账单集合
     */
    @Query("from BillEntity where tradeDate >= :startDate and tradeDate <= :endDate")
    public List<BillEntity> findByItem(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    /**
     * 通过id查询账单
     * @param billId 账单id
     * @return 账单实体
     */
    @Query("from BillEntity where billId = :billId")
    public BillEntity findById(@Param("billId") int billId);

    /**
     * 添加账单
     * @param billEntity 账单实体
     */
    public void addBill(BillEntity billEntity);
}
