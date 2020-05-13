package com.project.Service.impl;

import com.project.Service.IAdminService;
import com.project.dao.IAdminDao;
import com.project.entity.AdminEntity;

import java.util.List;

/**
 * 管理员业务接口实现类
 */
public class AdminServiceImpl implements IAdminService  {

    private IAdminDao adminDao;
    @Override
    public void addAdmin(AdminEntity admin) {
        adminDao.save(admin);
    }

    @Override
    public AdminEntity getAdminEntityById(int UserId) {
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
}
