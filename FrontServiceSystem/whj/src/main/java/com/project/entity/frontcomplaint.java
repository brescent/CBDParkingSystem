package com.project.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 投诉实体
 */
@Entity
@Table(name = "t_frontcomplaint")
public class frontcomplaint {
    /**
     * id
     */
    @Id
    @Column(name="pk_id",nullable=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    /**
     * 投诉内容
     */
    @Column(name = "complaintContant",length = 100)
    private  String complaintContant;
    /**
     * 投诉时间
     */
    @Column(name = "complaintTime")
    private Date complaintTime;

}
