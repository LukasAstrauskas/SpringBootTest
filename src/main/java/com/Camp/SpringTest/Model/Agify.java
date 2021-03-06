package com.Camp.SpringTest.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agify {
    private String name;
    private int age;
    private int count;

    public Agify() {
    }

    public Agify(String name) {
        this.name = name;
    }

    public Agify(String name, int age, int count) {
        this.name = name;
        this.age = age;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        String s = "Name: " + name + ", age: " + age + ", count:" + count + ".";
        return s;
    }
}
