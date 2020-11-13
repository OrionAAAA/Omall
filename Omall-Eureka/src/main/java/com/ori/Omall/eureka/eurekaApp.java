package com.ori.Omall.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Orion on 2020/11/13 14:38
 */

@SpringBootApplication
@EnableEurekaServer
public class eurekaApp {
    public static void main(String[] args) {
        SpringApplication.run(eurekaApp.class,args);
    }
}
