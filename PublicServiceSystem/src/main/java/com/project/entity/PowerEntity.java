package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_power")
public class PowerEntity {
    @Id
    private int id;

    @Column(name = "p_powerInfo")
    private int powerInfo;

    @ManyToOne
    @JoinColumn(name = "pk_adminId")
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
