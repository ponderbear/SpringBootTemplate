package com.example.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//将配置文件中的值与类的所有属性绑定,只有注册到bean管理中，才能用
//两种从配置文件取值方式：

// 1、整体注入@ConfigurationProperties,才可以松散绑定（名字可大小写、-等），一般用于PoJo直接对应
//@ConfigurationProperties(prefix = "person")
//加载指定配置文件@Properties。注意yaml和properties同时存在，且有同名的配置，yaml是后执行的，所有会用yaml的，去覆盖
@PropertySource(value = "classpath:person.properties", encoding = "UTF-8")
@Component
@Data
public class Person {

    //2、@Value分别注入，对比@Configuration，可多支持spel，计算语言，一般用作简单值的映射

    //2.1用spel表达式计算#{}
    @Value("#{${person.age}*2}")
    private int age;

    //2.2字面量
//    @Value("wangwang")

    @Value("${person.name}")
    private String name;

    //2.3从配置文件读取${}
    //@Value注解不支持复杂类型值的注入
    //@Value("${person.maps}")
    private Map<String,String> maps;
    private List<Object> lists;

}
