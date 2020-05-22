package com.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "t_power")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class PowerEntity {
    @Id
    @Column(name = "pk_powerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**权利名*/
    @Column(name = "p_powerInfo")
    private int powerInfo;

    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_adminId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
