package com.project.controller;

import com.project.entity.FrontDealEntity;
import com.project.entity.FrontOrderEntity;
import com.project.entity.FrontcomplaintEntity;
import com.project.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("front")
public class FrontController {
    /**
     * 订单业务
     */

    @Autowired
    private OrderServicempl orderServicempl;
    @Autowired
    private Complaintmpl complaintmpl;
    @Autowired
    private DealServicempl dealServicempl;
    @Autowired
    private StallServcempl stallServcempl;
    @Autowired
    private PactServicempl pactServicempl;



    @RequestMapping("/findAllorderById")
    @ResponseBody
    public List<FrontOrderEntity> findallorder(@PathParam("Userid") int id ){
         return   orderServicempl.orderByUserid(id);
    }

    /**
     * 交易信息添加管理
     * @param deal
     * @param id
     */
   @RequestMapping("/addDeal")
      public void addDeal(FrontDealEntity deal, @PathParam("stallId") int id){

      }

    /**
     * 根据Id
     * 删除交易信息
     * @param id
     */
      @RequestMapping("/dealDeal")
    public  void delDeal(@PathParam("dealId") int id){

    }

    /**
     * 根据id修改交易性息
     * @param deal
     */

    @RequestMapping("/updateDeal")
    public  void updateDeal(FrontDealEntity deal){

    }

    /**
     * 添加投诉
     * @param complaint
     * @param id
     */
      @RequestMapping("/addComplaint")
      public  void  addComplaint(FrontcomplaintEntity complaint, @PathParam("orderId") int id){
          FrontcomplaintEntity complaint1=complaint;
           FrontOrderEntity orderEntity=new FrontOrderEntity();
           orderEntity.setId(id);
          complaint1.setFrontOrderId(orderEntity);
        complaintmpl.addComplanit(complaint);
      }



}
