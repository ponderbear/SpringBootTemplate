package com.example.entity;

//自动下划线（数据库字段）转驼峰（实体类）
public class User {
    private String name;
    private String age;
    private Integer id;

    public User(String name, String age, Integer id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

//    mybatis映射机制，自动创建bean，使用无参构造方法创建
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
