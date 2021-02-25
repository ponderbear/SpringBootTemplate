package com.example.config;


import com.example.service.test.InjectedBeanTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuraiton:指明当前是个配置类，相当于之前的spring配置文件，统一管理bean
 *
 * @Bean 相当与<bean><bean/>标签
 *
 */
@Slf4j
@Configuration
public class MyConfig {


    //注意注入的bean在bean管理容器中的id是  方法名！！！
    @Bean
    public InjectedBeanTest injectedBeanTest(){
        log.info("通过@Configuration统一管理bean的注入");
        return new InjectedBeanTest();
    }
}
