package com.project.service;

import com.project.dto.PersonalUserDto;
import com.project.dto.UserDto;
import com.project.entity.PersonalUserEntity;
import com.project.entity.PublicUserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "publicUserService")
public interface IUserService {

    @GetMapping(value = "/login")
    public UserDto login(@RequestParam String userName,@RequestParam String pwd);

    @PostMapping("/addUser")
    public String addUser(Map userMap);

    @GetMapping("/getPersonalUserInfo/{userId}")
    public PersonalUserDto getPersonalUserInfo(@PathVariable("userId") int userId);

    @PutMapping("/user/updateUser")
    public void updatePersonalUser(String userName,@RequestParam PersonalUserDto personalUserDto);
}
