package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Order {
    private String storeName;

    //Spring默认使用Jackson的objectMapper自动处理字符串到date的映射，但只包括常见的pattern，如yyyy-MM-dd（传时的string到bean）
    //为了返回时的date格式只保留年月日，用@JsonFormat

    @JsonFormat(pattern = "yyyy-MM-dd")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")，无效
    private Date orderTime;

    private String userId;

    private String address;


    public Order(String storeName, Date orderTime, String userId, String address) {
        this.storeName = storeName;
        this.orderTime = orderTime;
        this.userId = userId;
        this.address = address;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "storeName='" + storeName + '\'' +
                ", orderTime=" + orderTime +
                ", userId='" + userId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
