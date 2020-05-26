package com.project.dto;

import com.project.entity.BillEntity;
import com.project.entity.PageEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TotalBillDto {
    /**账单数据页面实体*/
    PageEntity<BillEntity> page;

    /**账单总数据统计*/
    List<BillCountDto> billCountDtoList;

    public PageEntity<BillEntity> getPage() {
        return page;
    }

    public void setPage(PageEntity<BillEntity> page) {
        this.page = page;
    }

    public List<BillCountDto> getBillCountDtoList() {
        return billCountDtoList;
    }

    public void setBillCountDtoList(List<BillCountDto> billCountDtoList) {
        this.billCountDtoList = billCountDtoList;
    }
}
