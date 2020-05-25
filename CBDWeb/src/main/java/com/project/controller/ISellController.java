package com.project.controller;

import com.project.service.IReleaseSellService;
import com.project.service.IStallDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;


@RestController
public class ISellController {

    @Autowired
    private IStallDealService stallDealService;

    @Autowired
    private IReleaseSellService releaseSellService;

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


    /**
     * 获取图片名字进行上传
     * @param file
     * @return
     */
    @PostMapping("/addSingleFile")
    public String addSingleFile(@RequestParam("filename") MultipartFile file){
        String fileName = file.getOriginalFilename();
        if (file.isEmpty()) {
            return "请上传车位产权证件！";
        }
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        fileName = UUID.randomUUID()+suffixName;
        System.out.println(fileName);

        return fileName;
    }

    /**
     * 远程调用后进行添加发布出售车位信息
     * @param map
     */
    @PostMapping("/addSingle")
    public String addSingle(@RequestBody Map<String,String> map){
        if (map!=null){
            releaseSellService.addSingle(map);
            return "0";
        }
        return "1";
    }
}
