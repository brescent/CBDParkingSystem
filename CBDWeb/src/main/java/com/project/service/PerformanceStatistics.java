package com.project.service;

import com.project.entity.LogEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * 性能统计
 */
@Service
@Aspect
public class PerformanceStatistics {

    @Autowired
    IPublicService publicService;

    @Around("execution(* com.project.service..*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object obj = point.proceed();
        long time2 = System.currentTimeMillis();
        long useTime = (time2 - time1)/1000;
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        String logInfo = "执行" + className + "的" + methodName + "方法时，使用了" + useTime + "秒时间";
        //new LogEntity("性能统计",logInfo);
        publicService.addLog("性能统计",logInfo);
        return obj;
    }
}
