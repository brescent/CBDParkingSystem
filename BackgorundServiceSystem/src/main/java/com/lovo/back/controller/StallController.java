package com.lovo.back.controller;


import com.lovo.back.entity.PaginationBean;
import com.lovo.back.entity.StallEntity;
import com.lovo.back.service.IStallService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class StallController {
    @Autowired
    IStallService stallService;


    /**
     * 查询所有的 车位
     * @return 合条件的车位集合
     */
    @GetMapping("stall/findAllStall")
    public List<StallEntity> findAll(){


        return  stallService.findAll();
    }

    /**
     * 根据车位地址  车位编号分页动态查询
     * @param stallAddress 车位地址
     * @param stallNo 车位编号
     * @param page 当前页
     * @param size 每页记录数
     * @return 合条件的车位集合
     */
    @GetMapping("stall/findByItems/{stallAddress}/{stallNo}/{page}/{size}")
    public PaginationBean<StallEntity> findByIyems(@PathVariable("stallAddress")String stallAddress, @PathVariable("stallNo")String stallNo, @PathVariable("page")String page, @PathVariable("size")String size){

        return  stallService.findByItems(stallAddress,stallNo,Integer.parseInt(page),Integer.parseInt(size));

    }

    /**
     * 添加车位  批量添加
     * @param stallAddress  车位地址
     * @param addressNo 区域编号
     * @param total 总车位数
     * @param startNum 起始车位编号
     */


    @GetMapping("stall/addStall/{stallAddress}/{addressNo}/{total}/{startNum}/{peopleNo}")
    public  void  add(@PathVariable("stallAddress")String stallAddress,@PathVariable("addressNo")String addressNo,@PathVariable("total")String total,@PathVariable("startNum")String startNum
    ){



        stallService.add(stallAddress,addressNo,Integer.parseInt(total),Integer.parseInt(startNum));
    }


    /**
     * 根据车位id  修改车位所属人的身份证号
     * @param id   车位id
     * @param peopleNo 车位所属人的身份证号
     */
    @GetMapping("stall/updatePeopleNo/{id}/{peopleNo}")
    public void updatePeopleNo(@PathVariable("id") String id,@PathVariable("peopleNo")String peopleNo){

        stallService.updatePeopleNo(Integer.parseInt(id),peopleNo);
    }

    /**
     * 企业租户查看平台空闲车位
     * @return 符合条件的车位集合
     */
    @GetMapping("stall/findByState")
    public  List<StallEntity>  findByState(){


        return  stallService.findByState();
    }

}
