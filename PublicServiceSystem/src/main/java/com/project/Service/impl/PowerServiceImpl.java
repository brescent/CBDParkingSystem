package com.project.Service.impl;

import com.project.Service.IPowerService;
import com.project.dao.IPowerDao;
import com.project.entity.PowerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限业务接口实现类
 */
@Service
@Transactional
public class PowerServiceImpl implements IPowerService {

    @Autowired
    private IPowerDao powerDao;

    @Override
    public List<PowerEntity> getPowerByAdminId(int adminId) {
        return powerDao.getPowerByAdmidId(adminId);
    }

    @Override
    public void delPowerByAdminId(int adminId) {
        powerDao.delPowerByAdminId(adminId);
    }

    @Override
    public void addPower(PowerEntity power) {
        powerDao.save(power);
    }
}
