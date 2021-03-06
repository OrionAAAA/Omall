package com.ori.Omall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Orion on 2020/11/17 16:55
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ori.Omall.mapper")
public class OmallContentMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmallContentMsApplication.class,args);
    }
}
