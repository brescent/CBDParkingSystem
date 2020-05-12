package com.project.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * 日志实体类
 */
@Entity
@Table(name = "t_log")
public class LogEntity {
    /**日志id*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_logId")
    private int logId;
    /**操作时间*/
    @Column(name = "l_date")
    private Date logDate;
    /**操作记录*/
    @Column(name = "l_info")
    private String logInfo;

    public LogEntity() {
    }

    public LogEntity(Date logDate, String logInfo) {
        this.logDate = logDate;
        this.logInfo = logInfo;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }
}
