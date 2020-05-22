package com.project.controller;

import com.alibaba.fastjson.JSON;
import com.project.entity.FrontDealEntity;
import com.project.service.IStallService;
import com.project.service.impl.OrderServiceIml;
import com.project.service.impl.SellServiceImpl;
import com.project.vo.ShowDealTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BuyPakingController {

    @Autowired
    private SellServiceImpl sellService;

    @Autowired
    private IStallService stallService;

    @Autowired
    private OrderServiceIml orderServiceIml;

    /**
     *  发布出售车位
     *
     */
    @ResponseBody
    @RequestMapping(value = "/release/{tag}")
    public String release(@PathVariable("tag") int tag){
//        String url = ""+frontStallEntity;
//        float price, FrontStallEntity frontStallEntity, @RequestParam("filename") MultipartFile multipartFile, HttpServletRequest request
//        FrontDealEntity frontDealEntity = new FrontDealEntity();
//        frontDealEntity.setDealPrice(price);
//        frontDealEntity.setDealState(0);
//        frontDealEntity.setDealType(1);
//        sellService.saveDealInfo(frontDealEntity);
//
//        String filename = multipartFile.getOriginalFilename();
//
//        filename = System.currentTimeMillis()+filename.substring(filename.lastIndexOf("."));

         String info =  stallService.infoString(tag);

          return info;

    }

    @RequestMapping("/getDealDate/{tag}")
    public String getAllByDealEndDate(@PathVariable("tag") int tag){
        List<ShowDealTwo.showDealTwoVo> list = sellService.getDealById(tag);
        return JSON.toJSONString(list);
    }

    @RequestMapping("/getAllDeal")
    public String getAllDeal(){
        List<ShowDealTwo.showDealTwoVo> list = sellService.getAllDealTwo();
        return  JSON.toJSONString(list);
    }

    @RequestMapping("/saveOrder/{message}/{id}")
    public String saveOrder(@PathVariable("message") String message,@PathVariable("id") int id){
            String i =  orderServiceIml.saveOrder(message,id);
            return i;
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


}
