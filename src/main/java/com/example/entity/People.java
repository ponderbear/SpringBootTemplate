package com.example.entity;

public class People {
    private String Name;
    private String age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "Name='" + Name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
