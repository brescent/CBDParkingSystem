package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication  //springboot
@EnableEurekaServer   //注册服务器
public class CloudMain {
    public static void main(String[] args) {
        SpringApplication.run(CloudMain.class);
    }}
