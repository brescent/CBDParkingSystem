package com.project.Service.impl;

import com.project.Service.ICompanyUserService;
import com.project.dao.ICompanyDao;
import com.project.entity.CompanyUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 企业用户业务接口实现类
 */
@Service
@Transactional
public class CompanyUserServiceImpl implements ICompanyUserService    {

    @Autowired
    private ICompanyDao companyDao;


    @Override
    public void addCompany(CompanyUserEntity company) {
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
}
