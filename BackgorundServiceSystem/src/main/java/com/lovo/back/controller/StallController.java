package com.lovo.back.controller;


import com.alibaba.fastjson.JSON;
import com.lovo.back.dto.StallDto;
import com.lovo.back.entity.PaginationBean;
import com.lovo.back.entity.StallEntity;
import com.lovo.back.service.IStallService;

import org.apache.commons.collections4.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/stall")
public class StallController {
    @Autowired
    IStallService stallService;



    @GetMapping("/test")
    public  String  test(){
        return "可以的嘛";
    }
    /**
     * 查询所有的 车位
     * @return 合条件的车位集合
     */
    @GetMapping("findAllStall")
    public List<StallEntity> findAll(){


        return  stallService.findAll();
    }

    /**
     * 根据车位地址  车位编号分页动态查询
     * @param address 车位地址
     * @param stallNo 车位编号
     * @param currentPage 当前页
     * @param pageSize 每页记录数
     * @return 合条件的车位集合
     */

    @PostMapping ("findByItems")
    public String findByItems (@RequestBody Map<String,String> map)
    {

        return JSON.toJSONString(stallService.findByItems(map.get("address"),map.get("no"),Integer.parseInt(map.get("currentPage")),Integer.parseInt(map.get("pageSize"))));

    }



    @GetMapping ("addStall")
    public void add(@RequestBody Map<String,String> map){

         stallService.add(map.get("stallAddress"),map.get("addressNo"),Integer.parseInt(map.get("total")),Integer.parseInt(map.get("startNum")));
    }


    /**
     * 根据车位id  修改车位所属人的身份证号
     * @param id   车位id
     * @param peopleNo 车位所属人的身份证号
     */
    @GetMapping("updatePeopleNo/{id}/{peopleNo}")
    public void updatePeopleNo(@PathVariable("id") String id,@PathVariable("peopleNo")String peopleNo){

        stallService.updatePeopleNo(Integer.parseInt(id),peopleNo);
    }

    /**
     * 企业租户查看平台空闲车位
     * @return 符合条件的车位集合
     */
    @GetMapping("findByState")
    @ResponseBody
    public  List<StallEntity>  findByState(){

        return  stallService.findByState();

    }


    /**
     * 单个添加车位
     * @param stallAddress 车位地址
     * @param stallNo 车位编号
     * @param peopleNo 身份证号
     * @param stallImg 车位产权图片
     */


    @PostMapping("addSingle")
    public void addSingle(@RequestParam("stallAddress") String stallAddress,@RequestParam("stallNo") String stallNo,@RequestParam("peopleNo") String peopleNo,@RequestParam("stallImg") String stallImg){

        stallService.addSingle(stallAddress,stallNo,peopleNo,stallImg);
    }


    /**
     * 审核车位是否有效  修改为有效
     * @param id
     */
    @PutMapping("updateValid/{id}")
    @ResponseBody
    public void updateValid(@PathVariable("id") int id){

        stallService.updateValid(id);
    }

    /**
     * 查找所有无效的车位
     * @return
     */
    @GetMapping("findNoValid")
    @ResponseBody
    public List<StallEntity> findNoValid(){

        return  stallService.findNoValid();
    }


    /**
     * 通过身份证查找车位
     * @param peopleNo
     * @return
     */
    @GetMapping("findByPeopleNo/{peopleNo}")
    @ResponseBody
    public StallEntity findByPeopleNo(String peopleNo){


        return  stallService.findByPeopleNo(peopleNo);
    }

    /**
     *  新添加时候的 返回数据库刚新添的数据
     * @param stall
     * @return
     */
   @PostMapping("addAndReturn")
   @ResponseBody
   public  StallEntity addAndReturn(StallEntity stall){

     return   stallService.addAndReturn(stall);
    }


    @PostMapping("findByAddress")
    @ResponseBody
        public String findByAddress(String stallAddress){


       List<StallDto> list=new ArrayList<>();
       for(StallEntity s:stallService.findByAddress(stallAddress)){
           StallDto stallDto=new StallDto();
           stallDto.setId(s.getId());
           stallDto.setStallNo(s.getStallNo());

           list.add(stallDto);

       }


        return  JSON.toJSONString(list);

        }

}
