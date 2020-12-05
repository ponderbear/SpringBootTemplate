package com.example.entity;


import java.util.Objects;

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
    public boolean equals(Object o) {
//        1、完全是同一个对象
        if (this == o) return true;
//        2、比较的对象不存在，或本身的类型就不一样
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
//        3、最合理的相等，即两个对象的所有属性都相等
        return Objects.equals(Name, people.Name) &&
                Objects.equals(age, people.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, age);
    }

    @Override
    public String toString() {
        return "People{" +
                "Name='" + Name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
