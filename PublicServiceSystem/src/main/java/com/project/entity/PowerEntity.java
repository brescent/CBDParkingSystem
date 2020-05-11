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


}
