package com.project.service;

import com.project.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("publicUserService")
public interface IUserService {

    public UserDto login();
}
