package com.project.service.impl;

import com.project.dao.UserInfoDao;
import com.project.entity.FrontUserInfoEntity;
import com.project.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    /**
     *
     * @param id 用户id
     * @return 根据用户id查询该用户信息
     */
    @Override
    public Optional<FrontUserInfoEntity> findByIdUserinfo(int id) {
        return userInfoDao.findById(id);
    }
}
