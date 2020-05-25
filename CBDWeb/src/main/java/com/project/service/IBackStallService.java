package com.project.service;



import com.project.dto.StallDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient("backServerClient")
public interface IBackStallService {




    /**
     * 查询所有的 车位
     * @return 合条件的车位集合
     */
    @GetMapping("stall/findAllStall")
    public String findAll();

    /**
     * 根据车位地址  车位编号分页动态查询
     * @param address 车位地址
     * @param no 车位编号
     * @param currentPage 当前页
     * @param pageSize 每页记录数
     * @return 合条件的车位集合
     */

    @PostMapping( "stall/findByItems")
    public String findByItmesPage (@RequestBody Map<String,String> map);



    /**
     * 添加车位  批量添加
     * @param stallAddress  车位地址
     * @param addressNo 区域编号
     * @param total 总车位数
     * @param startNum 起始车位编号
     */


    @PostMapping("stall/addStall")
    public void add(@RequestBody Map<String,String> map);
//    public  void  add(@RequestParam("stallAddress") String stallAddress,@RequestParam("addressNo")String addressNo,@RequestParam("total")String total,@RequestParam("startNum")String startNum
//    );


    /**
     * 根据车位id  修改车位所属人的身份证号
     * @param id   车位id
     * @param peopleNo 车位所属人的身份证号
     */
    @GetMapping("stall/updatePeopleNo")
    public void updatePeopleNo(@RequestBody Map<String,String> map);


    /**
     * 企业租户查看平台空闲车位
     * @return 符合条件的车位集合
     */
    @GetMapping("/stall/findByState")
    public  String  findByState();


    /**
     * 单个添加车位
     * @param stallAddress 车位地址
     * @param stallNo 车位编号
     * @param peopleNo 身份证号
     * @param stallImg 车位产权图片
     */


    @PostMapping("stall/addSingle")
    public void addSingle(@RequestBody Map<String,String> map);



    /**
     * 审核车位是否有效  修改为有效
     * @param id
     */
    @PutMapping("stall/updateValid")
    public void updateValid(@PathVariable("id") int id);


    /**
     * 查找所有无效的车位
     * @return
     */
    @GetMapping("stall/findNoValid")

    public String findNoValid();

    /**
     * 通过身份证查找车位
     * @param peopleNo
     * @return
     */
    @GetMapping("stall")

    public String findByPeopleNo( String peopleNo);

    /**
     *  新添加时候的 返回数据库刚新添的数据
     * @param stall
     * @return
     */
    @PostMapping("stall/addAndReturn")

    public  String addAndReturn( @RequestBody Map<String,String> map);


    /**
     * 根据车位地址 找车位
     * @param stallAddress
     * @return
     */
    @PostMapping("stall/findByAddress")
    public String  findByAddress( String stallAddress);

}
