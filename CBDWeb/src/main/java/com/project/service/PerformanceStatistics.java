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

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * 性能统计
 */
@Service
@Aspect
public class PerformanceStatistics {

    @Autowired
    IPublicService publicService;

    @Around("execution(* com.project.controller..*.*(..))")
    public  Object around(ProceedingJoinPoint point) {
        long time1 = System.currentTimeMillis();
        Object obj = null;
        try {
            obj = point.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        long useTime = (time2 - time1);
        point.getTarget();
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        String logInfo = "执行" + className + "的" + methodName + "方法时，使用了" + useTime + "毫秒时间";
        //new LogEntity("性能统计",logInfo);
        publicService.addLog(logInfo,"性能统计");
       return obj;
    }
}
