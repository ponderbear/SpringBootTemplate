package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

//mybatis是调用同名的mapper实例化接口,并且通过接口中方法与mapper标签中的id同名，来调用mapper中的方法

@Component
public interface UserMapper {

    List<User> getUserByName(String userName);

// 注意insert和update除了单个参数、还可都以bean作为参数，然后在xml中以{#属性}从bean中抽取值

    Integer addUser(User user);

    Integer deleteUser(Integer userId);

}

