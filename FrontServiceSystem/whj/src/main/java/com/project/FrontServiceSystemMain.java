package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FrontServiceSystemMain {
    public static void main(String[] args) {
        SpringApplication.run(FrontServiceSystemMain.class);
    }
}
