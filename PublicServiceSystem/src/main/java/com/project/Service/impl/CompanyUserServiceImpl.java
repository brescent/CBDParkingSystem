package com.project.Service.impl;

import com.project.Service.ICompanyUserService;
import com.project.dao.ICompanyDao;
import com.project.dao.IUserDao;
import com.project.entity.CompanyUserEntity;
import com.project.entity.PublicUserEntity;
import com.project.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

/**
 * 企业用户业务接口实现类
 */
@Service
@Transactional
public class CompanyUserServiceImpl implements ICompanyUserService {

    @Autowired
    private ICompanyDao companyDao;

    @Autowired
    private IUserDao userDao;


    @Override
    public void addCompany(CompanyUserEntity company,String companyLoginName,String companyLoginPwd) {


        try {
            //将密码进行加密
            String md5pwd = MD5Util.getEncryptedPwd(companyLoginPwd);
            //创建一个企业用户对象
            PublicUserEntity userEntity = new PublicUserEntity(
                    companyLoginName,md5pwd,1);
            //保存用户
            userDao.save(userEntity);
            //设置企业的用户外键
            company.setPublicUserId(userEntity);
            //保存企业用户
            companyDao.save(company);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public CompanyUserEntity getCompanyUserById(int userId) {
        return companyDao.getCompanyUserById(userId);
    }

    @Override
    public List<CompanyUserEntity> getAllCompany() {
        return (List<CompanyUserEntity>) companyDao.findAll();
    }

    @Override
    public void delCompany(int companyId) {
        companyDao.deleteById(companyId);
    }

    @Override
    public void updCompany(String contact, String contactPhone, int companyId) {
        companyDao.updateCompanyUser(contact,contactPhone,companyId);
    }

    @Override
    public CompanyUserEntity getCompanyById(int companyId) {

      Optional<CompanyUserEntity> companyUserEntity = companyDao.findById(companyId);
        return companyUserEntity.get();
    }
}
