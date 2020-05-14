package com.project.controller;

import com.project.Service.IPowerServcie;
import com.project.Service.IUserService;
import com.project.dto.PowerDto;
import com.project.dto.UserDto;
import com.project.entity.*;
import com.project.util.CBDStringUtil;
import com.project.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    IUserService service;

    @Autowired
    IPowerServcie powerServcie;

    @RequestMapping("login/{userName}/{pwd}")
    public UserDto login(@PathVariable("userName") String userName,@PathVariable("pwd") String pwd){
        PublicUserEntity user=service.login(userName, pwd);
        int userType=user.getUserType();
        PublicUserEntity mainUser= service.findUserByName(userName);
        UserDto userDto=new UserDto();
        try {
            //用户输入密码再次加盐再与数据库保存的密码进行比较，存在返回用户对象，不存在返回null
            if(MD5Util.validPasswd(pwd,user.getPwd())){
                //System.out.println("欢迎用户"+user.getLoginName()+"登陆系统");
                //如果用户是管理员，查询权限
                if(userType==2){
                    List<PowerEntity> powerlist=powerServcie.getPowerByAdmidId(1);
                    List<PowerDto> powerDtoList=new ArrayList<>();
                    for(PowerEntity power:powerlist){
                        List<Integer> powerinfo= Collections.singletonList(power.getPowerInfo());
                        //遍历拿到的数组，进行比较
                        for (int i:powerinfo){

                            if (i==1){
                                String powerA="用户管理";
                                powerDtoList.add(new PowerDto(powerA));
                            }else if(i==2){
                                String powerB="车位管理";
                                powerDtoList.add(new PowerDto(powerB));
                            }else if(i==3){
                                String powerC="合同管理";
                                powerDtoList.add(new PowerDto(powerC));
                            }else if(i==4){
                                String powerD="投诉管理";
                                powerDtoList.add(new PowerDto(powerD));
                            }

                        }
                        //设置UserDto的属性
                        userDto.setPowerList(powerDtoList);
                        userDto.setLoginName(mainUser.getLoginName());
                        userDto.setId(mainUser.getId());
                        userDto.setPwd(pwd);
                        //判断用户属性，再进行设置用户的角色
                        if (mainUser.getUserType()==0){
                            userDto.setUserType(CBDStringUtil.PERSONAL_USER);
                        }else if(mainUser.getUserType()==1){
                            userDto.setUserType(CBDStringUtil.COMPANY_USER);
                        }else if(mainUser.getUserType()==2){
                            userDto.setUserType(CBDStringUtil.ADMIN_USER);
                        }else if(mainUser.getUserType()==3){
                            userDto.setUserType(CBDStringUtil.SUPERADMIN_USER);
                        }
                    }
                }
            }else {
                    return null;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return userDto;
    }


    @RequestMapping("addUser")
    public String addUser(PublicUserEntity publicUserEntity,PersonalUserEntity personalUserEntity){
        //通过姓名查找用户，如果用户存在，返回false
            PublicUserEntity mainUser=service.findUserByName(publicUserEntity.getLoginName());
            if(mainUser!=null){
                try {
                    //盐加密输入的密码，再将输入的密码保存到数据库
                    String  encryptedPwd = MD5Util.getEncryptedPwd(publicUserEntity.getPwd());
                    publicUserEntity.setPwd(encryptedPwd);
                    service.addUser(publicUserEntity, personalUserEntity);
                    return "";
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
            return CBDStringUtil.ADD_FAIL;
    }


    @RequestMapping("updateUser")
    public void updatePersonalUser(@PathVariable("email") String email,@PathVariable("jobInfo") String jobInfo,@PathVariable("phone") String phone,@PathVariable("homeAddress") String homeAddress,@PathVariable("userName") String userName,@PathVariable("pwd") String pwd,@PathVariable("userId") int userId){

    }
}
