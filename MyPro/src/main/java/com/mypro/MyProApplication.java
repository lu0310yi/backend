package com.mypro;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages={"com.mypro.mapper"})
public class MyProApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyProApplication.class, args);
    }

}
