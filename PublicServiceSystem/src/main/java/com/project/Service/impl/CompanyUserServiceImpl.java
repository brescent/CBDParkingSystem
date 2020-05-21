package com.project.Service.impl;

import com.alibaba.fastjson.JSON;
import com.project.Service.ICompanyUserService;
import com.project.dao.ICompanyDao;
import com.project.dao.ILogDao;
import com.project.dao.IUserDao;
import com.project.dto.CompanyDto;
import com.project.entity.CompanyUserEntity;
import com.project.entity.LogEntity;
import com.project.entity.PageEntity;
import com.project.entity.PublicUserEntity;
import com.project.util.CBDStringUtil;
import com.project.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import com.project.dao.BasicDao;

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

    @Autowired
    private ILogDao logDao;

    @Autowired
    private BasicDao basicDao;


    @Override
    public String addCompany(CompanyDto company) {

        try {
            //将密码进行加密
            String md5pwd = MD5Util.getEncryptedPwd(company.getCompanyLoginPwd());
            //创建一个企业用户对象
            PublicUserEntity userEntity = new PublicUserEntity(
                    company.getCompanyLoginName(), md5pwd, 1);
            //保存用户
            userDao.save(userEntity);

            LogEntity log = new LogEntity(
                    CBDStringUtil.ADMIN_USER,
                    "添加了" + company.getCompanyName() + "企业用户");
            logDao.save(log);
            //将dto的数据放到实体中

            CompanyUserEntity companyUserEntity = new CompanyUserEntity();
            companyUserEntity.setCompanyName(company.getCompanyLoginPwd());
            companyUserEntity.setCompanyAddress(company.getCompanyAddress());
            companyUserEntity.setContact(company.getContact());
            companyUserEntity.setContactPhone(company.getContactPhone());
            companyUserEntity.setPublicUser(userEntity);
            //保存企业用户
            companyDao.save(companyUserEntity);
            LogEntity logg = new LogEntity(
                    CBDStringUtil.ADMIN_USER,
                    "添加了" + company.getCompanyName());
            logDao.save(logg);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    @Override
    public String getCompanyUserById(int userId) {
        //根据用户id获取对应企业详情
        CompanyUserEntity companyUserEntity = companyDao.getCompanyUserById(userId);

        String josn = JSON.toJSONString(companyUserEntity);

        return josn;

    }


    @Override
    public String getAllCompany(String companyName, String companyAddress,
                                String contact, String contactPhone,
                                int pageNum, int pageSize) {
        //设置页码与显示条数
        PageRequest pageable = PageRequest.of(pageNum - 1, pageSize);


        //动态查询结果数据集合

        List<CompanyUserEntity> compList =
                basicDao.getAllCompany(
                        companyName, companyAddress,
                        contact, contactPhone,
                        pageNum, pageSize);
        //获取动态查询的数据总条数
//        int count = companyDao.findAllCount(companyName, companyAddress,
//                contact, contactPhone).get(0).intValue();
        int count = basicDao.getAllCouunt(companyName, companyAddress,
                contact, contactPhone);

        //将数据放进分页对象
        PageEntity<CompanyUserEntity> pageEntity = new PageEntity<>(compList, pageSize, pageNum, count);


        String json = JSON.toJSONString(pageEntity);

        return json;
    }

    @Override
    public String delCompany(int companyId) {
        //根据id删除企业
        try {
            companyDao.deleteById(companyId);

            //写日志
            LogEntity log = new LogEntity(
                    CBDStringUtil.ADMIN_USER,
                    "删除了id是" + companyId + "的企业用户");
            logDao.save(log);
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    @Override
    public String updCompany(String contact, String contactPhone, int companyId) {

       try {
           companyDao.updateCompanyUser(contact, contactPhone, companyId);
           return "1";
       }catch (Exception e){
           e.printStackTrace();
           return "0";
       }
    }

    @Override
    public String getCompanyById(int companyId) {

        Optional<CompanyUserEntity> companyUserEntity = companyDao.findById(companyId);
        CompanyUserEntity company = companyUserEntity.get();


        return JSON.toJSONString(company);
    }


}
