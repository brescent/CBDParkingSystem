package com.project.service.frontService;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("frontServiceSystem")
public interface IUserService {
}
