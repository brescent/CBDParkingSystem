package com.project.Service;

import com.project.entity.BillEntity;

import java.sql.Date;
import java.util.List;

/**
 * 账单业务层就接口
 */
public interface IBillService {

    /**
     * 动态查询账单
     * @param startDate 起始日期
     * @param endDate   终止日期
     * @return  账单集合
     */
    public List<BillEntity> findByItem(Date startDate,Date endDate);

    /**
     * 通过id查询账单
     * @param billId 账单id
     * @return 账单实体
     */
    public BillEntity findById(int billId);
}
