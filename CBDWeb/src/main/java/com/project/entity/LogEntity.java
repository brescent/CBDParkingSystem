package com.project.entity;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 日志实体类
 */

public class LogEntity {
    /**日志id*/

    private int logId;
    /**操作时间*/

    private Date logDate=new Date(System.currentTimeMillis());
    /**操作记录*/

    private String logInfo;


    public LogEntity() {
    }

    public LogEntity(String userName,String info) {
        this.logDate = logDate;
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
        this.logInfo =  "用户"+userName+"在"+simpleDateFormat.format(logDate)+info;
    }

    public LogEntity(int logId, Date logDate, String logInfo) {
        this.logId = logId;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss");
        this.logDate = logDate;
        this.logInfo = logInfo;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String  getLogDate() {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(logDate);
    }



    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }
}
