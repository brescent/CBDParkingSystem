package com.project.controller;


import com.project.service.frontService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FrontGotoController {
    @Autowired
    private IStallService stallService;
    @Autowired
    private IDealService dealService;
    @Autowired
    private IComplaintService complaintService;
    @Autowired
    private IPactService pactService;
    @Autowired
    private IOrderService orderService;


    @RequestMapping("getStallByuserId")
    private  String getStallById( int id){
  String str=stallService.getStallListByid(id);
        return str;
    }

    /**
     * 交易信息
     * @return
     */
    @RequestMapping("getAllDeal")
    private  String getAllDeallist(){
      String str= dealService.getAllDeallist();
        return str;
    }
    @RequestMapping("updateDealById/{id}/{state}")
    public void updateDealById(@RequestParam("id") int id , @RequestParam("id") int state){
            dealService.updateDealById(id,state);
    }
    @PostMapping("addDeal" )
    public  void  addDeal(@RequestBody Map map){

    dealService.addDeal(map);

    }
    @RequestMapping("/detDealById")
    public  String detDealById(@RequestBody Map map){

      return   dealService.detDealById(map);
    }
    /**
     * 投诉
     * @return
     */
    @RequestMapping("getAllComplaintlist")
    public String getAllComplaintlist(){
        String str=complaintService.getAllComplaintlist();
        return str;
    }
    @RequestMapping("updateComplaintById/{id}/{state}")
    public void updateComplaintById(@PathVariable("id") int id ,@PathVariable("state") int state){
        complaintService.updateComplaintById(id ,state);

    }
    @RequestMapping("/addComplaint")
    public  void  addComplaint(@RequestBody Map map){
        complaintService.addComplaint(map);
    }
    @RequestMapping("getAllPact")
    public String getAllPact() {
        String str=pactService.getAllPact();
        return str;
    }

    @RequestMapping("getComplaintById/{id}")
    public  String getComplaintById(@PathVariable("id") int id){
        return complaintService.getComplaintById(id);
    }


    /*
    订单
     */
    @RequestMapping("addOrder")
    public  void  addOrder(@RequestBody Map map){
        orderService.addOrder(map);
    }

    @RequestMapping("getAllOrderByUserId")
    public String getAllOrderByUserId( @RequestBody Map map){
         return     orderService.getAllOrderByUserId(map);}

    @RequestMapping("getOrderById")
    public String getOrderById(@RequestBody Map map){
     return    orderService.getOrderById(map);
    }
}
