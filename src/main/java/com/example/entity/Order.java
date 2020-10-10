package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order {

    private Integer orderId;

    private String storeName;

    //Spring默认使用Jackson的objectMapper自动处理字符串到date的映射，但只包括常见的pattern，如yyyy-MM-dd（传时的string到bean）
    //为了返回时的date格式只保留年月日，用@JsonFormat

    @JsonFormat(pattern = "yyyy-MM-dd")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")，无效
    private Date orderTime;

    private Integer userId;

    private String address;

    private String userName;



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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Order(){};

    public Order(Integer orderId, String storeName, Date orderTime, Integer userId, String address, String userName) {
        this.orderId = orderId;
        this.storeName = storeName;
        this.orderTime = orderTime;
        this.userId = userId;
        this.address = address;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", storeName='" + storeName + '\'' +
                ", orderTime=" + orderTime +
                ", userId='" + userId + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
