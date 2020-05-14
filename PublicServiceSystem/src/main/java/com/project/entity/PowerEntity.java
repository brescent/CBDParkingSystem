package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_power")
public class PowerEntity {
    @Id
    @Column(name = "pk_powerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "p_powerInfo")
    private int powerInfo;

    @ManyToOne
    @JoinColumn(name = "fk_adminId")
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
