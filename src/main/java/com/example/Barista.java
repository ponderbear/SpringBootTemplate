package com.example;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//注意启动类不能直接放在java目录下，要在一个包里
@MapperScan(basePackages = "com.example.mapper")
//扫描mapper类
public class Barista {
    public static void main(String args[]){
        SpringApplication.run(Barista.class , args);
    }
}
