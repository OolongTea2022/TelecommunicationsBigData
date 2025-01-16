package com.bigdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bigdata.dao")
public class TelecommunicationsBigDataBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelecommunicationsBigDataBackEndApplication.class, args);
    }

}
