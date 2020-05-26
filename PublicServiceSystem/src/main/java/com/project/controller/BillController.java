package com.project.controller;

import com.project.Service.IBillService;
import com.project.Service.IUserService;
import com.project.entity.BillEntity;
import com.project.entity.PageEntity;
import com.project.util.CBDStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class BillController {

    @Autowired
    private IBillService billService;

    @Autowired
    private IUserService userService;

    /**
     * 添加账单
     * @param userName 用户名
     * @param tradePrice 交易金额，正数为收入，负数为支出
     * @param billInfo 交易备注
     */
    @PostMapping("addBill/{userName}")
    public String addBill(@PathVariable("userName") String userName, Double tradePrice, String billInfo){
        BillEntity billEntity = new BillEntity();
        if (tradePrice > 0){
            billEntity.setIncome(tradePrice);
        }else if (tradePrice < 0){
            billEntity.setPaid(tradePrice);
        }
        billEntity.setUser(userService.findUserByName(userName));
        billEntity.setBillInfo(billInfo);
        billService.addBill(billEntity);

        return CBDStringUtil.ADD_SUCCESS;
    }

    @GetMapping("findBillList")
    public PageEntity<BillEntity> findBillList(int userId, Date startDate, Date endDate, int pageSize, int pageNum){
        PageEntity<BillEntity> page = billService.findByItem(userId,startDate,endDate,pageSize,pageNum);
        return page;
    }

    @GetMapping("findById/{billId}")
    public BillEntity findById(@PathVariable("billId") int billId){
        return billService.findById(billId);
    }
}
