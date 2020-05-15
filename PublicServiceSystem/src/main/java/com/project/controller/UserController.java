//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.project.controller;

import com.project.Service.ILogService;
import com.project.Service.IPowerService;
import com.project.Service.IUserService;
import com.project.dto.PersonalUserDto;
import com.project.dto.PowerDto;
import com.project.dto.UserDto;
import com.project.entity.LogEntity;
import com.project.entity.PersonalUserEntity;
import com.project.entity.PowerEntity;
import com.project.entity.PublicUserEntity;
import com.project.util.CBDStringUtil;
import com.project.util.MD5Util;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService service;
    @Autowired
    IPowerService powerService;
    @Autowired
    ILogService logService;

    public UserController() {
    }

    @PostMapping({"login/{userName}/{pwd}"})
    public UserDto login(@PathVariable("userName") String userName, @PathVariable("pwd") String pwd) {
        PublicUserEntity user = this.service.login(userName, pwd);
        int userType = user.getUserType();
        PublicUserEntity mainUser = this.service.findUserByName(userName);
        UserDto userDto = new UserDto();

        try {
            if (!MD5Util.validPasswd(pwd, user.getPwd())) {
                return null;
            }

            if (userType == 2) {
                List<PowerEntity> powerlist = this.powerService.getPowerByAdminId(mainUser.getId());
                List<PowerDto> powerDtoList = new ArrayList();
                Iterator var9 = powerlist.iterator();

                while(var9.hasNext()) {
                    PowerEntity power = (PowerEntity)var9.next();
                    List<Integer> powerinfo = Collections.singletonList(power.getPowerInfo());
                    Iterator var12 = powerinfo.iterator();

                    while(var12.hasNext()) {
                        int i = (Integer)var12.next();
                        String powerD;
                        if (i == 1) {
                            powerD = "用户管理";
                            powerDtoList.add(new PowerDto(powerD));
                        } else if (i == 2) {
                            powerD = "车位管理";
                            powerDtoList.add(new PowerDto(powerD));
                        } else if (i == 3) {
                            powerD = "合同管理";
                            powerDtoList.add(new PowerDto(powerD));
                        } else if (i == 4) {
                            powerD = "投诉管理";
                            powerDtoList.add(new PowerDto(powerD));
                        }
                    }

                    userDto.setPowerList(powerDtoList);
                    userDto.setLoginName(mainUser.getLoginName());
                    userDto.setId(mainUser.getId());
                    userDto.setPwd(pwd);
                    if (mainUser.getUserType() == 0) {
                        userDto.setUserType(CBDStringUtil.PERSONAL_USER);
                    } else if (mainUser.getUserType() == 1) {
                        userDto.setUserType(CBDStringUtil.COMPANY_USER);
                    } else if (mainUser.getUserType() == 2) {
                        userDto.setUserType(CBDStringUtil.ADMIN_USER);
                    } else if (mainUser.getUserType() == 3) {
                        userDto.setUserType(CBDStringUtil.SUPERADMIN_USER);
                    }
                }

                LogEntity log = new LogEntity(userName,CBDStringUtil.LOGIN_LOG);
                this.logService.addLog(log);
            }
        } catch (NoSuchAlgorithmException var15) {
            var15.printStackTrace();
        } catch (UnsupportedEncodingException var16) {
            var16.printStackTrace();
        }

        return userDto;
    }

    @RequestMapping({"addUser"})
    public String addUser(PublicUserEntity publicUserEntity, PersonalUserEntity personalUserEntity) {
        PublicUserEntity mainUser = this.service.findUserByName(publicUserEntity.getLoginName());
        if (mainUser != null) {
            try {
                String encryptedPwd = MD5Util.getEncryptedPwd(publicUserEntity.getPwd());
                publicUserEntity.setPwd(encryptedPwd);
                this.service.addUser(publicUserEntity, personalUserEntity);
                LogEntity log = new LogEntity(publicUserEntity.getLoginName(), CBDStringUtil.ADDUSER_LOG);
                this.logService.addLog(log);
            } catch (NoSuchAlgorithmException var6) {
                var6.printStackTrace();
            } catch (UnsupportedEncodingException var7) {
                var7.printStackTrace();
            }
        }

        return CBDStringUtil.ADD_FAIL;
    }

    @GetMapping({"getPersonalUserInfo/{userId}"})
    public PersonalUserDto getPersonalUserInfo(@PathVariable("userId") int userId) {
        PersonalUserEntity user = this.service.findByPublicUserId(userId);
        PersonalUserDto userDto = new PersonalUserDto();
        userDto.setEmail(user.getEmail());
        userDto.setHomeAddress(user.getHomeAddress());
        userDto.setPhone(user.getPhone());
        userDto.setPhone(user.getPhone());
        return userDto;
    }

    @RequestMapping({"updateUser"})
    public void updatePersonalUser(String userName, PersonalUserDto personalUserDto) {
        PublicUserEntity maiuUser = this.service.findUserByName(userName);
        PersonalUserEntity user = this.service.findByPublicUserId(maiuUser.getId());
        user.setPhone(personalUserDto.getPhone());
        user.setJobInfo(personalUserDto.getJonInfo());
        user.setEmail(personalUserDto.getEmail());
        user.setHomeAddress(personalUserDto.getHomeAddress());
        String encryptedPwd = null;

        try {
            encryptedPwd = MD5Util.getEncryptedPwd(personalUserDto.getPwd());
            maiuUser.setPwd(encryptedPwd);
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
        } catch (UnsupportedEncodingException var8) {
            var8.printStackTrace();
        }

        LogEntity log = new LogEntity(userName,CBDStringUtil.UPDATEUSER_LOG);
        this.logService.addLog(log);
        this.service.updatePersonalUser(user, maiuUser.getId(), maiuUser);
    }
}
