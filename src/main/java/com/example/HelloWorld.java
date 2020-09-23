package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//注意启动类不能直接放在java目录下，要在一个包里
public class HelloWorld {
    public static void main(String args[]){
        SpringApplication.run(HelloWorld.class , args);

    }
}
