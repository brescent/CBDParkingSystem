package com.project.controller;

import com.project.Service.IBillService;
import com.project.Service.IUserService;
import com.project.entity.BillEntity;
import com.project.util.CBDStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

@RequestMapping("bill")
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

    @GetMapping("findByItem")
    public List<BillEntity> findByItem(int userId, Date startDate, Date endDate){
        List<BillEntity> billList = billService.findByItem(userId,startDate,endDate);
        return billList;
    }

    @GetMapping("findById/{billId}")
    public BillEntity findById(@PathVariable("billId") int billId){
        return billService.findById(billId);
    }
}
