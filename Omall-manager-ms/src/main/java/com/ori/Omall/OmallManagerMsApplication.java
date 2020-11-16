package com.ori.Omall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Orion on 2020/11/16 9:28
 */
@SpringBootApplication
@MapperScan("com.ori.Omall.mapper")
public class OmallManagerMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmallManagerMsApplication.class,args);
    }
}
