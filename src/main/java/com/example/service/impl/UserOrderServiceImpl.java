package com.example.service.impl;

import com.example.entity.Order;
import com.example.mapper.UserOrderMapper;
import com.example.service.UserOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserOrderServiceImpl implements UserOrderService {


    @Resource
    private UserOrderMapper userOrderMapper;

    @Override
    public List<Order> getUserOrder(Integer userId, Integer orderId) {
        //二级缓存测试，二级缓存与sqlsessionFactory生命周期（应用级）绑定
        //同sql+参数在第一次sqlsession关闭后，结果才会保存（在spring的sqlsessiontmplate每次查询（工程内部方法）时自动重新创建sqlsession，刚好可测）
        //第二次查询。。。就会检测
        List<Order> orderList2 = userOrderMapper.getUserOrder(userId,orderId);
        log.info("设置之前的地址："+orderList2.get(0).getAddress());
        orderList2.get(0).setAddress("测试变化");
        log.info("sss");
        List<Order> orderList3 =  userOrderMapper.getUserOrder(userId,orderId);
        log.info("设置之后，命中的地址："+orderList3.get(0).getAddress());
        //缓存取得是对象引用，可以变化具体值
        return orderList3;
    }

    @Override
    //开启事务
    @Transactional
    public List<Order> getUserAllOrder(Integer userId){
        Order order = new Order();
        order.setAddress("上海");
        order.setUserId(userId);
        //一级缓存测试，每次一个新的http请求都会创建新的sqlsession，范围是请求或方法内
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

    @Override
    public List<Order> getAllOrder() {
        return userOrderMapper.getAllOrder();
    }
}
