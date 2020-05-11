package com.project.entity;

import javax.persistence.*;

/**
 * 合同实体
 */
@Entity
@Table(name = "t_frontPact")
public class frontPact {
    /**
     * id
     */
    @Id
    @Column(name="pk_id",nullable=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    /**
     * 合同状态
     */
    @Column(name = "pactState",length = 10)
    private int pactState;
}

