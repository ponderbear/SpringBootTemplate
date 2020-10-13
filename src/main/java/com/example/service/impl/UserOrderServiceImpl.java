package com.example.service.impl;

import com.example.entity.Order;
import com.example.mapper.UserOrderMapper;
import com.example.service.UserOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    //开启事务
    @Transactional
    public List<Order> getUserAllOrder(Integer userId){
        Order order = new Order();
        order.setAddress("上海");
        order.setUserId(userId);
        //每次一个新的http请求都会创建新的sqlsession，范围是请求或方法内
        //sqlsessionFactory是应用（application）级别的
        //一级缓存与sqlsession相绑定，所以两次系统的sql+参数只会查询一次，结果用缓存
        //其他：mybatis和spring结合时，默认spring创建sqlsession时用的sqlsessiontemplate（每次查询时会新建一个sqlsession，用完后commite），
        // 可开启事务,sqlsessionholder维护一个session，用时取出
        List<Order> newOrder1 = userOrderMapper.getUserAllOrder(order);
        order.setUserId(4);
        //更改了参数，会重复查一次
        List<Order> newOrder2 = userOrderMapper.getUserAllOrder(order);

        return userOrderMapper.getUserAllOrder(order);
    }

    @Override
    public List<Order> getPartialUserOrder(List<String> userIds){
        return userOrderMapper.getPartialUserOrder(userIds);
    }


}
