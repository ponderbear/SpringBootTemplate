package com.example.service;

import com.example.entity.Order;

import java.util.List;

public interface UserOrderService {

    public List<Order> getUserOrder(Integer userId, Integer orderId);

    List<Order> getUserAllOrder(Integer userId);

    List<Order> getPartialUserOrder(List<String> userIds);

    List<Order> getAllOrder();
}
