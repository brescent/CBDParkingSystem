package com.project.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class dealDto {

    private int id;
    /**
     * 交易价格
     */

    private float dealPrice;
    /**
     * 交易开始时间
     */

    private Date dealStartDate;
    /**
     * 交易结束时间
     */
    private Date dealEndDate;
    /**
     * 0为审核中，1为交易中 2失效 3为审核失败
     */

    private int dealState;
    /**
     * 交易时间
     */

    private Date dealTime=new Date(System.currentTimeMillis());
    /**
     *交易类型
     * 0为出租，1出售，
     */

    private int dealType;
/*
   车位id
 */
    private   int Stallid;
   /*
   车位地址
    */
    private String stallAddress;
/*
   身份证号
 */
    private String IDNum;
//       投诉次数
    private  int complaintNum;
    /**
     * 职业
     */
    private String userProfession;

      /*
      用户名
       */
    private String userName;

}
