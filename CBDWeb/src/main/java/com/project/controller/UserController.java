package com.project.controller;


import com.project.dto.UserDto;

import com.project.entity.PersonalUserEntity;
import com.project.entity.PublicUserEntity;
import com.project.service.IUserService;
import com.project.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping(value = "login")
    @ResponseBody
    public  String  login(String userName,String pwd, HttpServletRequest request) {
       UserDto userDto= userService.login(userName, pwd);
       if (userDto !=null){

           request.getSession().setAttribute("user",userDto);
           return "1";
       }else {

       }

        return "2";
    }

    @PostMapping("addUser")
    @ResponseBody
    public String addUser(@RequestBody UserVo userVo,HttpServletRequest request){
        userService.addUser(userVo);
        UserDto userDto=new UserDto();
        userDto=userService.login(userVo.getLoginName(),userVo.getPwd());
        if(userDto ==null){
            return "2";
        }
        request.getSession().setAttribute("user",userDto);
        return "1";
    }


    @GetMapping("getLoginUserName")
    @ResponseBody
    public String getLoginUserName(HttpServletRequest request){
         UserDto userDto= (UserDto) request.getSession().getAttribute("user");
        String userName=userDto.getLoginName();
        return "欢迎"+userName+"用户使用CBD停车场系统";
    }
}
