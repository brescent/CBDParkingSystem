package com.project.Service.impl;

import com.project.Service.IUserService;
import com.project.dao.IAdminDao;
import com.project.dao.ICompanyDao;
import com.project.dao.IPersonalUserDao;
import com.project.dao.IUserDao;
import com.project.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Autowired
    IPersonalUserDao personalUserDao;

    @Autowired
    ICompanyDao companyDao;

    @Autowired
    IAdminDao adminDao;

    @Override
    public  void login(String userName, String pwd) {
         PublicUserEntity mainUser= userDao.login(userName, pwd);
    }

    @Override
    public void updatePersonalUser(String email, String jobInfo, String phone, String homeAddress, String userName, String pwd, int userId) {
        userDao.updatepublicUser(pwd,userId,userName);
        personalUserDao.updatePersonalUser(email, jobInfo, homeAddress, phone, userId);
    }

    @Override
    public void addUser(PublicUserEntity publicUser, PersonalUserEntity personalUser) {
        userDao.save(publicUser);
        personalUserDao.save(personalUser);
    }

    @Override
    public Object getUserInfo(int userType, int userId) {
        if(userType==0){
            PersonalUserEntity personalUser=personalUserDao.getPersonalUser(userId);
        }else if (userType==1){
            CompanyUserEntity companyUser=companyDao.getCompanyUserById(userId);
        }else if(userType==2){
            AdminEntity admin=adminDao.getAdminEntityById(userId);
            List<PowerEntity> powerList=adminDao.getPowerByAdmidId(userId);
        }
        return null;
    }
}
