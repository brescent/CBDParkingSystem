package com.lovo.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 外部合约与车位关系中间表
 */
@Data
@Entity
@Table(name = "outContract_stall")
public class OutContractAndStall implements Serializable {
    @Id
    /*外部合约与车位关系主键*/
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*外部合约外键*/
    @ManyToOne
    @JoinColumn(name = "fk_outContractId")
    private OutContractEntity outContract;
    /*车位信息外键*/
    @ManyToOne
    @JoinColumn(name = "fk_stallId")
    private StallEntity stall;

}
