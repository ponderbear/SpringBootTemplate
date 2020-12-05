package com.example.entity;

import java.util.List;

public class User {
    private String name;
    private String age;
    private Integer id;

    private List<Order> userOrder;

    public User(String name, String age, Integer id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

//    mybatis映射机制，自动创建bean时(mapper返回值)是使用无参构造方法创建，然后是使用setter方法塞值
    public User(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Order> getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(List<Order> userOrder) {
        this.userOrder = userOrder;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                ", userOrder=" + userOrder +
                '}';
    }
}
