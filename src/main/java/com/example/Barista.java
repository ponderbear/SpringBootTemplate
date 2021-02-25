package com.example;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@Configuration(主配置类（配置文件）)+@EnableAutoConfiguration（开启自动配置）
@SpringBootApplication
//注意启动类不能直接放在java目录下，要在一个包里
//@ImportResource(locations = {"classpath:某个bean的xml配置文件，强行让springboot通过xml的方式注入管理的bean，不推荐使用"})
@MapperScan(basePackages =   "com.example.mapper")
//扫描mapper类
public class Barista {
    public static void main(String args[]){
        SpringApplication.run(Barista.class , args);
    }
}
