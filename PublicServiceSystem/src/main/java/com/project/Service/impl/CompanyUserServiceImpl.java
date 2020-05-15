package com.project.Service.impl;

import com.project.Service.ICompanyUserService;
import com.project.dao.ICompanyDao;
import com.project.dao.ILogDao;
import com.project.dao.IUserDao;
import com.project.entity.CompanyUserEntity;
import com.project.entity.LogEntity;
import com.project.entity.PageEntity;
import com.project.entity.PublicUserEntity;
import com.project.util.CBDStringUtil;
import com.project.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    @Autowired
    private ILogDao logDao;

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

            LogEntity log = new LogEntity(
                    CBDStringUtil.ADMIN_USER,
                    "添加了" +companyLoginName+"企业用户");
            logDao.save(log);
            //设置企业的用户外键
            company.setPublicUser(userEntity);
            //保存企业用户
            companyDao.save(company);
            LogEntity logg = new LogEntity(
                    CBDStringUtil.ADMIN_USER,
                    "添加了" +company.getCompanyName());
            logDao.save(logg);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public CompanyUserEntity getCompanyUserById(int userId) {
        //根据用户id获取对应企业详情
        return companyDao.getCompanyUserById(userId);

    }



    @Override
    public PageEntity<CompanyUserEntity> getAllCompany(String companyName, String companyAddress,
                                    String contact, String contactPhone ,
                                    int pageNum, int pageSize) {
        //设置页码与显示条数
        PageRequest pageable=PageRequest.of(pageNum-1,pageSize);

        //动态查询结果数据集合
        List<CompanyUserEntity> compList = companyDao.findAllCompany( companyName,  companyAddress,
                 contact,  contactPhone ,pageable);

        //获取动态查询的数据总条数
        int count = companyDao.findAllCount(companyName,  companyAddress,
                contact,contactPhone).get(0).intValue();

        //将数据放进分页对象
        PageEntity<CompanyUserEntity> pageEntity = new PageEntity<>(compList,pageSize,pageNum,count);


        return pageEntity;
    }

    @Override
    public void delCompany(int companyId) {
        //根据id删除企业
        companyDao.deleteById(companyId);
        //写日志
        LogEntity log = new LogEntity(
                CBDStringUtil.ADMIN_USER,
                "删除了id是" +companyId+"的企业用户");
        logDao.save(log);
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
