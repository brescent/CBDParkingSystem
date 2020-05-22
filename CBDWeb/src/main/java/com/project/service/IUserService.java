package com.project.service;

import com.project.dto.PersonalUserDto;
import com.project.dto.UserDto;
import com.project.entity.PersonalUserEntity;
import com.project.entity.PublicUserEntity;
import com.project.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "publicUserService")
public interface IUserService {

    @GetMapping(value = "/login")
    public UserDto login(@RequestParam String userName,@RequestParam String pwd);

    @PostMapping("/addUser")
    public String addUser(UserVo userVo);

    @GetMapping("/getPersonalUserInfo/{userId}")
    public PersonalUserDto getPersonalUserInfo(@PathVariable("userId") int userId);

    @PostMapping("/updateUser")
    public void updatePersonalUser(PersonalUserDto personalUserDto);
}
