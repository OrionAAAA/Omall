package com.ori.Omall.search;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Orion on 2020/11/25 9:42
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.ori.Omall.mapper")
public class SearchApp {
    public static void main(String[] args) {
        SpringApplication.run(SearchApp.class,args);
    }
}
