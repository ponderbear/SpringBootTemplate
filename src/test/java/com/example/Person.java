package com.example;

import com.example.service.test.InjectedBeanTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


//使用Spring的启动器而不是Junit的启动器跑
@RunWith(SpringRunner.class)
//该注解自动加载Spring的配置文件和管理的bean，便于测试时注入bean
@SpringBootTest
public class Person {

//    @Resource
//    InjectedBeanTest injectedBeanTest;

    @Resource
    com.example.entity.Person person;

    @Resource
    ApplicationContext applicationContext;

    @Test
    public void prin(){
        //要启动该类，test的类必须和applcaiton类在src中的目录相同
        System.out.println(person);
    }

    @Test
    public void configInjectedTest(){

        //Spring 注入bean的三种方式：1、xml文件(spring boot 不推荐）2、@Configuration注解充当xml配置文件一次性管理 3、Bean打@Component单独管理
        //bean名默认是@Configuration中的方法名，而不是类名小写！！
        Boolean beanExist = applicationContext.containsBean("injectedBeanTest");
        System.out.println(beanExist);

    }
}
