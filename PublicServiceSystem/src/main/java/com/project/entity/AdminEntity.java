package com.project.entity;

import javax.persistence.*;
import java.util.List;

/**管理员实体类*/

@Entity
@Table(name = "t_admin")
public class AdminEntity {
    /**管理员ID*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_adminId")
    private Integer id;

    /**管理员工号*/
    @Column(name = "a_jobNum")
    private int jobNum;

    /**管理员真实姓名*/
    @Column(name = "a_realName")
    private String realName;

    @OneToOne
    @JoinColumn(name = "fk_publicUserId")
    private PublicUserEntity publicUser;

    @OneToMany(mappedBy = "admin")
    private List<PowerEntity> powerList;

    public AdminEntity() {
    }

    public AdminEntity(int jobNum,String realName) {
        this.realName=realName;
        this.jobNum=jobNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobNum() {
        return jobNum;
    }

    public void setJobNum(int jobNum) {
        this.jobNum = jobNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public PublicUserEntity getPublicUserId() {
        return publicUser;
    }

    public void setPublicUserId(PublicUserEntity publicUserId) {
        this.publicUser = publicUserId;
    }

    public List<PowerEntity> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<PowerEntity> powerList) {
        this.powerList = powerList;
    }
}
