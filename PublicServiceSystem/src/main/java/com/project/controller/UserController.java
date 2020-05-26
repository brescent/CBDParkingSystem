//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.project.controller;

import com.project.Service.IAdminService;
import com.project.Service.ILogService;
import com.project.Service.IPowerService;
import com.project.Service.IUserService;
import com.project.dto.PersonalUserDto;
import com.project.dto.PowerDto;
import com.project.dto.UserDto;
import com.project.entity.*;
import com.project.util.CBDStringUtil;
import com.project.util.MD5Util;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import com.project.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    IUserService service;
    @Autowired
    IPowerService powerService;
    @Autowired
    ILogService logService;

    @Autowired
    IAdminService adminService;

    public UserController() {
    }

    @GetMapping(value = "login")
    public UserDto login(String userName,String pwd) {
        //通过用户名查找用户
        PublicUserEntity mainUser = this.service.findUserByName(userName);
        if(mainUser==null){
            return null;
        }
        //获得用户类型
        int userType = mainUser.getUserType();
        UserDto userDto = new UserDto();
        List<PowerDto> powerDtoList = new ArrayList();
        //通过盐加密的解密算法，验证密码
        try {
            if (!MD5Util.validPasswd(pwd, mainUser.getPwd())) {
                return null;
            }
            //如果用户类型是2或者3，也就是管理员或则超级管理员
            if (userType == 2||userType==3) {
                //通过用户id查找管理员信息
                AdminEntity admin=adminService.getAdminEntityByUserId(mainUser.getId());
                //通过管理员id查找权限集合
                List<PowerEntity> powerlist = this.powerService.getPowerByAdminId(admin.getId());

                //循环遍历权限集合，对权限集合dto设置权限名
                for (PowerEntity power:powerlist) {

                        if (power.getPowerInfo() == 0) {
                            PowerDto powerA = new PowerDto(CBDStringUtil.POWER_0);
                            powerDtoList.add(powerA);
                        } else if (power.getPowerInfo() == 1) {
                            PowerDto powerB = new PowerDto(CBDStringUtil.POWER_1);
                            powerDtoList.add(powerB);
                        } else if (power.getPowerInfo() == 2) {
                            PowerDto powerC = new PowerDto(CBDStringUtil.POWER_2);
                            powerDtoList.add(powerC);
                        } else if (power.getPowerInfo() == 3) {
                            PowerDto powerD = new PowerDto(CBDStringUtil.POWER_3);
                            powerDtoList.add(powerD);
                        }
                    }
                }

            //设置用户属性
            userDto.setPowerList(powerDtoList);
            userDto.setLoginName(mainUser.getLoginName());
            userDto.setId(mainUser.getId());
            userDto.setPwd(pwd);
            //判断用户的用户类型
            if (mainUser.getUserType() == 0) {
                userDto.setUserType(CBDStringUtil.PERSONAL_USER);
            } else if (mainUser.getUserType() == 1) {
                userDto.setUserType(CBDStringUtil.COMPANY_USER);
            } else if (mainUser.getUserType() == 2) {
                userDto.setUserType(CBDStringUtil.ADMIN_USER);
            } else if (mainUser.getUserType() == 3) {
                userDto.setUserType(CBDStringUtil.SUPERADMIN_USER);
            }
            //书写日志
            LogEntity log = new LogEntity(userName,CBDStringUtil.LOGIN_LOG);
            this.logService.addLog(log);

        } catch (NoSuchAlgorithmException var15) {
            var15.printStackTrace();
        } catch (UnsupportedEncodingException var16) {
            var16.printStackTrace();
        }

        return userDto;
    }

    @PostMapping("addUser")
    public String addUser(@RequestBody UserVo userVo) {
        PublicUserEntity publicUserEntity= new PublicUserEntity();
        publicUserEntity.setUserType(0);
        PersonalUserEntity personalUserEntity= new PersonalUserEntity();
        PublicUserEntity mainUser = this.service.findUserByName(userVo.getLoginName());
        if (mainUser == null) {
            //设置用户属性
            publicUserEntity.setUserType(0);
            publicUserEntity.setLoginName(userVo.getLoginName());
            publicUserEntity.setPwd(userVo.getPwd());
            personalUserEntity.setPhone(userVo.getPhone());
            personalUserEntity.setHomeAddress(userVo.getHomeAddress());
            personalUserEntity.setJobInfo(userVo.getJobInfo());
            personalUserEntity.setIDCardNum(userVo.getCardNum());
            personalUserEntity.setRealName(userVo.getRealName());
            personalUserEntity.setPublicUser(publicUserEntity);
            personalUserEntity.setEmail(userVo.getEmail());
            try {
                String encryptedPwd = MD5Util.getEncryptedPwd(publicUserEntity.getPwd());
                publicUserEntity.setPwd(encryptedPwd);
                this.service.addUser(publicUserEntity, personalUserEntity);
                LogEntity log = new LogEntity(publicUserEntity.getLoginName(), CBDStringUtil.ADDUSER_LOG);
                this.logService.addLog(log);
                return "1";
            } catch (NoSuchAlgorithmException var6) {
                var6.printStackTrace();
            } catch (UnsupportedEncodingException var7) {
                var7.printStackTrace();
            }
        }else {
            return null;
        }

        return  null;
    }

    /**
     * 前端修改方法，先通过id查找用户详情回显
     * @param userId
     * @return
     */
    @GetMapping("getPersonalUserInfo/{userId}")
    public PersonalUserDto getPersonalUserInfo(@PathVariable("userId") int userId) {
        PersonalUserEntity user = this.service.findByPublicUserId(userId);
        PersonalUserDto userDto = new PersonalUserDto();
        userDto.setEmail(user.getEmail());
        userDto.setHomeAddress(user.getHomeAddress());
        userDto.setPhone(user.getPhone());
        userDto.setPhone(user.getPhone());
        userDto.setJobInfo(user.getJobInfo());
        return userDto;
    }

    /**
     * 修改格瑞特
     *
     * @param personalUserDto
     */
    @PostMapping("updateUser")
    public void updatePersonalUser(@RequestBody PersonalUserDto personalUserDto) {
        PublicUserEntity maiuUser = this.service.findUserByName(personalUserDto.getUserName());
        PersonalUserEntity user = this.service.findByPublicUserId(maiuUser.getId());
        user.setPhone(personalUserDto.getPhone());
        user.setJobInfo(personalUserDto.getJobInfo());
        user.setEmail(personalUserDto.getEmail());
        user.setHomeAddress(personalUserDto.getHomeAddress());
        String encryptedPwd = null;

        try {
            if(personalUserDto.getPwd()!=null){
                encryptedPwd = MD5Util.getEncryptedPwd(personalUserDto.getPwd());
                maiuUser.setPwd(encryptedPwd);
            }

        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
        } catch (UnsupportedEncodingException var8) {
            var8.printStackTrace();
        }

        LogEntity log = new LogEntity(personalUserDto.getUserName(),CBDStringUtil.UPDATEUSER_LOG);
        this.logService.addLog(log);
        this.service.updatePersonalUser(user, maiuUser.getId(), maiuUser);
    }
}
