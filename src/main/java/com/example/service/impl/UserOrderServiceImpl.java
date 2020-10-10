package com.example.service.impl;

import com.example.entity.Order;
import com.example.mapper.UserOrderMapper;
import com.example.service.UserOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {


    @Resource
    private UserOrderMapper userOrderMapper;

    @Override
    public List<Order> getUserOrder(Integer userId, Integer orderId) {
        return userOrderMapper.getUserOrder(userId,orderId);
    }

    @Override
    public List<Order> getUserAllOrder(Integer userId){
        Order order = new Order();
        order.setAddress("上海");
        order.setUserId(userId);
        return userOrderMapper.getUserAllOrder(order);
    }

    @Override
    public List<Order> getPartialUserOrder(List<String> userIds){
        return userOrderMapper.getPartialUserOrder(userIds);
    }


}
