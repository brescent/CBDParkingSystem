package com.project.Service;

import com.project.entity.BillEntity;
import com.project.entity.PageEntity;

import java.sql.Date;

/**
 * 账单业务层就接口
 */

public interface IBillService {

    /**
     * 动态查询账单
     * @param startDate 起始日期
     * @param endDate   终止日期
     * @param pageSize  每页条数
     * @param pageNum   页码
     * @return  分页实体
     */
    public PageEntity<BillEntity> findByItem(int userId, Date startDate, Date endDate, int pageSize, int pageNum);

    /**
     * 通过id查询账单
     * @param billId 账单id
     * @return 账单实体
     */
    public BillEntity findById(int billId);

    /**
     * 添加账单
     * @param billEntity 账单实体
     */
    public void addBill(BillEntity billEntity);

}
