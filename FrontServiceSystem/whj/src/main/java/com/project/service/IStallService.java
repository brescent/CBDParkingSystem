package com.project.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("clienttwo")
public interface IStallService {

    @RequestMapping(value = "infoString/{tag}")
    String infoString(@PathVariable("tag") int tag);

}
