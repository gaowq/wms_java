package com.example.wms_java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.wms_java.mapper.ClassifyMapper")
public class WmsJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmsJavaApplication.class, args);
    }

}
