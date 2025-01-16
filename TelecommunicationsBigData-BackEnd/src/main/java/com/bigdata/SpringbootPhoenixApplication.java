package com.bigdata;

//启动类

//springboot+springmvc+spring+mybatis
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.bigdata.dao")
public class SpringbootPhoenixApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootPhoenixApplication.class,args);
    }
}
