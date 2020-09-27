package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import com.example.service.UserOrder;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserOrderImpl implements UserOrder {


    @Resource
    private UserMapper userMapper;

    @Override
    public String getUserOrder(String userId) {
        return null;
    }

    @Override
    @ResponseBody
    public List<User> gerUserName(String userId) {
        List<User> userList = userMapper.getAllUser();
        return userList;
    }
}
