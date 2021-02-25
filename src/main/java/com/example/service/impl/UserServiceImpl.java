package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//注意是实现类作为bean创建
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Long addUser(User user) {
        Integer userKey = userMapper.addUser(user);
        return Integer.valueOf(user.getId()).longValue();
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.getUserAscOrderPri(Integer.valueOf(id.intValue()));
    }

    @Override
    public List<User> getUserByName(String UserName) {
        List<com.example.entity.User> userList = userMapper.getUserByName(UserName);
        return userList;
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public void getUserRelectTest(){
        System.out.println("通过反射调用代理类，调用目标类的方法，查询的结果");
    }
}
