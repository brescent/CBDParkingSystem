package com.project.entity;


import lombok.Data;

import javax.persistence.*;

/**公共用户类*/

@Data
public class PublicUserEntity {
    /**用户id*/
    private int id;
    /**用户登录名*/

    private String loginName;
    /**用户密码*/

    private String pwd;
    /**用户类型*/


}
