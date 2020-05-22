package com.project.entity;


import com.project.vo.AdminVo;

public class PowerEntity {

    private int id;

    /**权利名*/

    private int powerInfo;


    private AdminVo admin;

    public PowerEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPowerInfo() {
        return powerInfo;
    }

    public void setPowerInfo(int powerInfo) {
        this.powerInfo = powerInfo;
    }

    public AdminVo getAdmin() {
        return admin;
    }

    public void setAdmin(AdminVo admin) {
        this.admin = admin;
    }
}
