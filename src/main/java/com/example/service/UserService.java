package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    Long addUser(User user);

    User getUser(Integer id);

    Integer deleteUser (Integer id);

    public List<User> getUserByName(String userName);

    public void getUserRelectTest();


}
