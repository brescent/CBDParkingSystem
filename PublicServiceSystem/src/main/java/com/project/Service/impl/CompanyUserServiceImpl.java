package com.project.Service.impl;

import com.project.Service.ICompanyUserService;
import com.project.dao.ICompanyDao;
import com.project.dao.IUserDao;
import com.project.entity.CompanyUserEntity;
import com.project.entity.PublicUserEntity;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 企业用户业务接口实现类
 */
@Service
@Transactional
public class CompanyUserServiceImpl implements ICompanyUserService    {

    @Autowired
    private ICompanyDao companyDao;

    @Autowired
    private IUserDao userDao;


    @Override
    public void addCompany(CompanyUserEntity company,String companyLoginName,String companyLoginPwd) {
        PublicUserEntity userEntity = new PublicUserEntity(companyLoginName,companyLoginPwd,1);

        userDao.save(userEntity);
        company.setPublicUserId(userEntity);

        companyDao.save(company);
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
