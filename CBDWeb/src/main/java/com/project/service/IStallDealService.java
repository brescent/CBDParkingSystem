package com.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("frontServiceSystem")
public interface IStallDealService {

    @RequestMapping("getDealDate/{tag}")
    String getAllByDealEndDate(@PathVariable("tag") int tag);

    @RequestMapping("getAllDeal")
    String getAllDeal();

    @RequestMapping("/getDealDate/{tag}")
    String getDealById(@PathVariable("tag") int id);

    @RequestMapping("/saveOrder/{message}/{id}")
    String saveOrder(@PathVariable("message") String message,@PathVariable("id") int id);

}
