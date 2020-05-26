package com.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.project.entity.*;
import com.project.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.project.util.strToDate.strToDate;

@RestController
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
    public List<FrontOrderEntity> findallorder(@PathParam("Userid") int id ){
         return   orderServicempl.orderByUserid(id);
    }

    /**
     * 交易信息添加管理
     * @param
     * @param
     */

    @PostMapping("addDeal")
    public void  addDeal(@RequestBody Map map){
        FrontStallEntity f= new FrontStallEntity();
        f.setStallAddress((String) map.get("addressNum"));
        f.setStallNum((String) map.get("stallNum"));
        f.setStallAddress((String) map.get("stallAddress"));
        int fId= stallServcempl.addStall(f);
        System.out.println(fId);
        f.setId(fId);
        FrontDealEntity fd=new FrontDealEntity();
        fd.setFrontStallId(f);
        fd.setDealPrice(Float.parseFloat((String) map.get("price")) );
        fd.setDealEndDate(strToDate((String) map.get("endTime")));
        fd.setDealStartDate(strToDate((String) map.get("startTime")));
        dealServicempl.addDeal(fd);
    }

    /**
     * 根据Id
     * 删除交易信息
     * @param
     */
      @RequestMapping("/detDealById")
    public  String detDealById( @RequestBody Map map){
                int dealid =Integer.parseInt((String) map.get("Dealid"));
                int Num =complaintmpl.getComplaintNum(dealid);
          List<Map> list = dealServicempl.getDealById(dealid);
            Map newmap=new HashMap(list.get(0));
          newmap.put("complaintNum",Num);

          String str= JSON.toJSONStringWithDateFormat(newmap,"yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat);
          return  str;
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
     * @param
     * @param
     */
      @RequestMapping("/addComplaint")
      public  void  addComplaint(@RequestBody Map map){
          FrontcomplaintEntity complaint=new FrontcomplaintEntity();
           FrontOrderEntity orderEntity=new FrontOrderEntity();
           orderEntity.setId(Integer.parseInt((String) map.get("Orderid")));
          FrontUserInfoEntity fo= new FrontUserInfoEntity();
          fo.setId((Integer) map.get("UserId"));
          complaint.setFrontOrderId(orderEntity);
          complaint.setComplaintContant((String) map.get("msg"));
          complaint.setUserInfoEntity(fo);
        complaintmpl.addComplanit(complaint);
      }

    @RequestMapping("getComplaintNum")
    public int getComplaintNum(int id) {
        return   complaintmpl.getComplaintNum(id);
    }

    @RequestMapping("showStallListByid")
      public String getStallListByUserId(int id){
            List<FrontStallEntity> list = stallServcempl.getStallByUserId(id);
          String str= JSON.toJSONString(list);
         return  str;
      }

    /**
     * 交易信息
     * @return
     */
    @RequestMapping("getAllDeallist")
    public String getAllDeallist(){
        JSONObject.DEFFAULT_DATE_FORMAT="yyyy-MM-dd";
        List<Map> list = dealServicempl.getAllDeal();
        String str= JSON.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);

        System.out.println(str);
        return  str;
    }
    @RequestMapping("updateDealById/{id}/{state}")
    public void updateDealById(@PathVariable("id") int id , @PathVariable("id") int state){
        dealServicempl.updateDealById(id,state);
    };


    @RequestMapping("getAllComplaintlist")
    public String getAllComplaintlist(){

        List<Map> list = complaintmpl.getAllComplaint();
        String str= JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat);

        return  str;
    }
   @RequestMapping("updateComplaintById/{id}/{state}")
     public void updateComplaintById(@PathVariable("id") int id , @PathVariable("id") int state){
       complaintmpl.updateById(id,state);
     };
    @RequestMapping("getComplaintById/{id}")
    public  String getComplaintById(@PathVariable("id") int id){
      Map map=  complaintmpl.getComplaintById(id);
        String str= JSON.toJSONStringWithDateFormat(map,"yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat);

        return  str;
    };





    @RequestMapping("getAllPact")
    public String getAllPact() {
        List<Map> list = pactServicempl.getAllPact();
        String str= JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat);
        return  str;
    }

    /**
     * 订单操作
     */

    @RequestMapping("addOrder")
    public  void  addOrder(@RequestBody Map map){

      FrontDealEntity fd=  new FrontDealEntity();

      fd.setId((Integer) map.get("Dealid"));
      FrontOrderEntity fo=new FrontOrderEntity();
      fo.setFrontcomplaintId(fd);
      fo.setMessage((String) map.get("msg"));
      orderServicempl.addOrder(fo);


    };
    @RequestMapping("getAllOrderByUserId")
    public String getAllOrderByUserId( @RequestBody Map map){
        int userid= (int) map.get("userId");
     List<Map> list =  orderServicempl.getAllOrderByUserId(userid);
        String str= JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat);
        return  str;
    };
    @RequestMapping("getOrderById")
    public String getOrderById(@RequestBody Map map){
        List<Map> list =  orderServicempl.getOrderById(Integer.parseInt((String) map.get("Orderid")));
          String str= JSON.toJSONStringWithDateFormat(list.get(0),"yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat);
        return  str;
    }
}
