package com.project.dto;

import lombok.Data;

/**
 * 总账单数居Dto
 */

public class BillCountDto {

    /**总交易笔数*/
    int totalCount;

    /**总支出*/
    Double totalPaid;

    /**总收入*/
    Double totalReceived;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(Double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Double getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(Double totalReceived) {
        this.totalReceived = totalReceived;
    }
}
