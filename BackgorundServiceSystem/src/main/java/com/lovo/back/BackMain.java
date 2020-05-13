package com.lovo.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient //客户端
////@EnableFeignClients   //feign进行远程调用
////@EnableCircuitBreaker  //熔断
public class BackMain {
    public static void main(String[] args) {
        SpringApplication.run(BackMain.class);
    }
    
}
