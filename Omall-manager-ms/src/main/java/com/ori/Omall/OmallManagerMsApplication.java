package com.ori.Omall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Orion on 2020/11/16 9:28
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ori.Omall.mapper")
public class OmallManagerMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmallManagerMsApplication.class,args);
    }
}
