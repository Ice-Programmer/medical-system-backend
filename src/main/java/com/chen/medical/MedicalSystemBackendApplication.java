package com.chen.medical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.chen.medical.mapper")
@EnableScheduling
@EnableAspectJAutoProxy
public class MedicalSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalSystemBackendApplication.class, args);
    }

}
