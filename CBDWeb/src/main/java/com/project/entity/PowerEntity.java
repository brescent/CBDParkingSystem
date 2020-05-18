package com.project.entity;

import javax.persistence.*;


public class PowerEntity {

    private int id;

    /**权利名*/

    private int powerInfo;


    private AdminEntity admin;

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

    public AdminEntity getAdmin() {
        return admin;
    }

    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
    }
}
