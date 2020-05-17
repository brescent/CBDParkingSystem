package com.project.Service.impl;

import com.project.Service.IAdminService;
import com.project.dao.IAdminDao;
import com.project.dao.ILogDao;
import com.project.dao.IPowerDao;
import com.project.dao.IUserDao;
import com.project.entity.*;
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

    @Autowired
    private ILogDao logDao;

    /**
     * 添加管理员
     * @param admin 管理员实体
     * @param pwd   管理员密码
     */
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

            LogEntity log = new LogEntity(CBDStringUtil.SUPERADMIN_USER,"添加管理员用户");
            logDao.save(log);


            //保存管理员进数据库
            adminDao.save(admin);
            LogEntity log2 = new LogEntity(CBDStringUtil.SUPERADMIN_USER,"添加管理员");
            logDao.save(log2);

            //循环添加管理员权限
            for(PowerEntity p : admin.getPowerList()){
                //设置权限的管理员id
                p.setAdmin(admin);
                //保存
                powerDao.save(p);
                LogEntity logg = new LogEntity(
                        CBDStringUtil.SUPERADMIN_USER,
                        "为管理员"+admin.getRealName()+"添加了权限"+p.getPowerInfo());
                logDao.save(logg);
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
        AdminEntity adminEntity =adminDao.getAdminEntityById(adminId);
        return adminEntity;
    }

    @Override
    public AdminEntity getAdminEntityByUserId(int UserId) {
        return adminDao.getAdminEntityById(UserId);
    }

    @Override
    public PageEntity<AdminEntity> getAllAdmin(int pageNum, int pageSize) {

        //设置当前页码以及显示条数
        PageRequest pageable=PageRequest.of(pageNum-1,pageSize);
        //分页查询所有管理员
        List<AdminEntity> adminEntityList = adminDao.getAllAdmin(pageable);
        //查询当前管理员数量
        int count = adminDao.getAdminCount();

        //将数据放进分页实体
        PageEntity<AdminEntity> pageEntity = new PageEntity<>(
                adminEntityList,pageSize,pageNum,count);

        return pageEntity;
    }

    @Override
    public void delAdmin(int adminId) {
        //根据管理员id删除对应权限
        powerDao.delPowerByAdminId(adminId);
        //根据id删除管理员
        adminDao.deleteById(adminId);

        LogEntity logg = new LogEntity(
                CBDStringUtil.SUPERADMIN_USER,
                "删除了id是" +adminId+"的管理员以及他的权限");
        logDao.save(logg);

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

            LogEntity logg = new LogEntity(
                    CBDStringUtil.SUPERADMIN_USER,
                    "修改了id是" +adminId+"的管理员权限,现在权限是"+p);
            logDao.save(logg);

        }
    }
}
