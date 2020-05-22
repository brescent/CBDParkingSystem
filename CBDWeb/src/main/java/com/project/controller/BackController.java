package com.project.controller;


import com.project.entity.PaginationBean;
import com.project.dto.StallDto;
import com.project.service.IStallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.PagedResultsResponseControl;

@RestController
@RequestMapping("back")
public class BackController {

    @Autowired
    IStallService stallService;

    @GetMapping("stall/findByItems/{stallAddress}/{stallNo}/{page}/{size}")
    public PaginationBean<StallDto>  findByItems(@PathVariable("stallAddress")String stallAddress, @PathVariable("stallNo")String stallNo, @PathVariable("page")String page, @PathVariable("size")String size){

        return  stallService.findByItems(stallAddress,stallNo,page,size);
    }


}
