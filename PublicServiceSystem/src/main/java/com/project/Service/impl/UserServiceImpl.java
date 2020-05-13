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
    public  PublicUserEntity login(String userName, String pwd) {
         PublicUserEntity mainUser= userDao.login(userName, pwd);
         return mainUser;
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
    public PublicUserEntity findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }


}
