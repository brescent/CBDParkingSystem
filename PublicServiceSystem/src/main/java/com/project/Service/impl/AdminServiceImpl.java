package com.project.Service.impl;

import com.project.Service.IAdminService;
import com.project.dao.IAdminDao;
import com.project.dao.IPowerDao;
import com.project.dao.IUserDao;
import com.project.entity.AdminEntity;
import com.project.entity.PowerEntity;
import com.project.entity.PublicUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 管理员业务接口实现类
 */
@Service
@Transactional
public class AdminServiceImpl implements IAdminService  {

    @Autowired
    private IAdminDao adminDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IPowerDao powerDao;

    @Override
    public void addAdmin(AdminEntity admin,String pwd) {
        //创建一个公共用户对象,并设置添加的登录名以及密码
        PublicUserEntity userEntity = new PublicUserEntity( admin.getJobNum()+"",pwd,2);

        userDao.save(userEntity);
        admin.setPublicUserId(userEntity);
        adminDao.save(admin);
    }



    @Override
    public AdminEntity getAdminById(int adminId) {
        Optional<AdminEntity> adminEntity =adminDao.findById(adminId);
        return adminEntity.get();
    }

    @Override
    public AdminEntity getAdminEntityByUserId(int UserId) {
        return adminDao.getAdminEntityById(UserId);
    }

    @Override
    public List<AdminEntity> getAllAdmin() {
        return (List<AdminEntity>) adminDao.findAll();
    }

    @Override
    public void delAdmin(int adminId) {
        adminDao.deleteById(adminId);
    }

    @Override
    public void updAdminPower(int adminId, int[] newPower) {

        powerDao.delPowerByAdminId(adminId);
        AdminEntity adminEntity  =new AdminEntity();
        adminEntity.setId(adminId);
        for (int p : newPower){
            PowerEntity powerEntity = new PowerEntity();
            powerEntity.setPowerInfo(p);
            powerEntity.setAdmin(adminEntity);
            powerDao.save(powerEntity);

        }
    }
}
