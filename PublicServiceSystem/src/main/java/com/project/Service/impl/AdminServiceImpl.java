package com.project.Service.impl;

import com.project.Service.IAdminService;
import com.project.dao.IAdminDao;
import com.project.dao.IPowerDao;
import com.project.dao.IUserDao;
import com.project.entity.AdminEntity;
import com.project.entity.PowerEntity;
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
 * 管理员业务接口实现类
 */
@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminDao adminDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPowerDao powerDao;

    @Override
    public void addAdmin(AdminEntity admin,String pwd) {


        try {

            //将密码进行加密
            String md5pwd = MD5Util.getEncryptedPwd(pwd);
            //创建一个公共用户对象,并设置添加的登录名以及密码
            PublicUserEntity userEntity = new PublicUserEntity(
                    admin.getJobNum()+"",md5pwd,2);
            //保存用户
            userDao.save(userEntity);
            //设置管理员用户id
            admin.setPublicUser(userEntity);
            //保存管理员进数据库
            adminDao.save(admin);
            //循环添加管理员权限
            for(PowerEntity p : admin.getPowerList()){
                //设置权限的管理员id
                p.setAdmin(admin);
                //保存
                powerDao.save(p);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }



    @Override
    public AdminEntity getAdminById(int adminId) {
        //根据id获取管理员
        Optional<AdminEntity> adminEntity =adminDao.findById(adminId);
        return adminEntity.get();
    }

    @Override
    public AdminEntity getAdminEntityByUserId(int UserId) {
        return adminDao.getAdminEntityById(UserId);
    }

    @Override
    public List<AdminEntity> getAllAdmin() {
        //查询所有管理员
        return (List<AdminEntity>) adminDao.findAll();
    }

    @Override
    public void delAdmin(int adminId) {
        //根据管理员id删除对应权限
        powerDao.delPowerByAdminId(adminId);
        //根据id删除管理员
        adminDao.deleteById(adminId);
    }

    @Override
    public void updAdminPower(int adminId, int[] newPower) {

        //根据管理员id删除对应权限
        powerDao.delPowerByAdminId(adminId);
        //创建一个管理员对象,保存id
        AdminEntity adminEntity  =new AdminEntity();
        adminEntity.setId(adminId);
        //循环保存新权限
        for (int p : newPower){
            //创建一个权限对象,保存管理员外键,以及权限说明
            PowerEntity powerEntity = new PowerEntity();
            powerEntity.setPowerInfo(p);
            powerEntity.setAdmin(adminEntity);
            //保存
            powerDao.save(powerEntity);

        }
    }
}
