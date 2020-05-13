package com.project.dao;

import com.project.entity.BillEntity;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * 账单持久层接口
 */
@Repository
public interface IBillDao {

    /**
     * 动态查询账单
     * @param startDate 起始日期
     * @param endDate   终止日期
     * @return  账单集合
     */
    public List<BillEntity> findByItem(Date startDate, Date endDate);

    /**
     * 通过id查询账单
     * @param billId 账单id
     * @return 账单实体
     */
    public BillEntity findById(int billId);
}
