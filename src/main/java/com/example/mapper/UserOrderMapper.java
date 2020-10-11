package com.example.mapper;

import com.example.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserOrderMapper {

    List<Order> getUserOrder(@Param("user") Integer userId, @Param("order") Integer orderId);

    List<Order> getUserAllOrder(Order userOrder);
    //mybatis不支持方法重载
//    List<Order> getUserAllOrder(Integer userId);

    List<Order> getUserAssociatedOrder(Integer userId);

    List<Order> getPartialUserOrder(@Param("userIds")List<String> userIds);
}
