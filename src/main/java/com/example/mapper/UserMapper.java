package com.example.mapper;

import com.example.entity.User;

import java.util.List;

//mybatis是调用同名的mapper是实例化接口
public interface UserMapper {

    List<User> getAllUser();

    Integer addUser(User user);

    Integer deleteUser(Integer userId);

}

