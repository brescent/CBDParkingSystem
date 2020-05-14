package com.project.Service.impl;

import com.project.Service.IUserService;
import com.project.dao.*;
import com.project.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService  {

    @Autowired
    IUserDao userDao;

    @Autowired
    IPersonalUserDao personalUserDao;

    @Autowired
    ICompanyDao companyDao;

    @Autowired
    IAdminDao adminDao;

    @Autowired
    IPowerDao powerDao;

    @Override
    public  PublicUserEntity login(String userName, String pwd) {
         PublicUserEntity mainUser= userDao.login(userName, pwd);
         return  mainUser;
    }

    @Override
    public void updatePersonalUser(PersonalUserEntity personalUserEntity, int userId, PublicUserEntity publicUserEntity) {
        userDao.save(publicUserEntity);
        personalUserEntity.setPublicUser(publicUserEntity);
        personalUserDao.save(personalUserEntity);
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

    @Override
    public PersonalUserEntity findByPublicUserId(int publicUserId) {
        return personalUserDao.getPersonalUser(publicUserId);
    }


}
