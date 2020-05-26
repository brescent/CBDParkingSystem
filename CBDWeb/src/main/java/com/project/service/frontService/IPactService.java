package com.project.service.frontService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("frontServiceSystem")
public interface IPactService {
//    public  void  addPact(FrontPactEntity frontPactEntity);
//    public void  delPact(int id);
//    public void  updatePact(FrontPactEntity frontPactEntity);
//    public FrontPactEntity  selPact(int id);
    @RequestMapping("getAllPact")
    public String getAllPact() ;
}
