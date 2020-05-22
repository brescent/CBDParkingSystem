package com.project.service;


import com.project.entity.PaginationBean;
import com.project.dto.StallDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("backServer")
public interface IStallService {


    @RequestMapping("stall/findByItems/{stallAddress}/{stallNo}/{page}/{size}")
    public PaginationBean<StallDto> findByItems(@PathVariable("stallAddress")String stallAddress, @PathVariable("stallNo")String stallNo, @PathVariable("page")String page, @PathVariable("size")String size);
}
