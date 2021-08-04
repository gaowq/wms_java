package com.example.wms_java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
//@SpringBootConfiguration
//@EnableAutoConfiguration
public class WmsJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmsJavaApplication.class, args);
    }

}
