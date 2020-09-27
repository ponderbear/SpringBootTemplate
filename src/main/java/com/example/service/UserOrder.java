package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserOrder {

    public String getUserOrder(String userId);

    public List<User> gerUserName(String userId);
}
