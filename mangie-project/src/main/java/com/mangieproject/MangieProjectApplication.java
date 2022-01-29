package com.mangieproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mangieproject.Repository")
public class MangieProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangieProjectApplication.class, args);
    }
}