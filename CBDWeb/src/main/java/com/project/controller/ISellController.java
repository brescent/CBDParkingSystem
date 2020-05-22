package com.project.controller;

import com.project.service.IStallDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ISellController {

    @Autowired
    private IStallDealService stallDealService;

    @RequestMapping("/test/{tag}")
    public String getAllByDealEndDate(@PathVariable("tag") int tag){

        return stallDealService.getAllByDealEndDate(tag);
    }

    @RequestMapping("/getAllDeal")
    public String getAllDeal(){
        return stallDealService.getAllDeal();
    }

    @RequestMapping("/getDealDate/{tag}")
    public String getDealById(@PathVariable("tag") int id){
        return stallDealService.getDealById(id);
    }

    @RequestMapping("/saveOrder/{message}/{id}")
    public String saveOrder(@PathVariable("message") String message,@PathVariable("id") int id){
        String i ;
        if (stallDealService.saveOrder(message,id)!=null){
            i="1";
        }else {
            i="0";
        }
        return i;
    }
}