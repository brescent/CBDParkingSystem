package com.project.service.frontService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@FeignClient("frontService")
public interface IComplaintService {
//
//    public  void  addComplanit(FrontcomplaintEntity frontcomplaintEntity);
//    public void  delComplaint(int id);
//    public FrontcomplaintEntity selComplaint(int id);
    @RequestMapping("getAllComplaintlist")
    public String getAllComplaintlist();
    @RequestMapping("updateComplaintById")
    public  void  updateComplaintById(@RequestParam("id") int id, @RequestParam("state") int state);
    @RequestMapping("addComplaint")
    public  void  addComplaint(Map map);

    @RequestMapping("getComplaintById/{id}")
    public  String getComplaintById(@PathVariable("id") int id);

}
