package com.project.service.frontService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("frontService")
public interface IStallService {
//    @RequestMapping("addStall")
//   public  int  addStall(FrontStallEntity frontStallEntity);
//    public void  delStall(int id);
//    public void  updateStall(FrontStallEntity frontStallEntity);
//    public FrontStallEntity  selStall(int id);

    @RequestMapping("showStallListByid")
    public String getStallListByid(@RequestParam("id") int id);
}
