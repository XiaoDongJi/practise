package com.dd;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: jixd
 * @date: 2020/7/29 6:04 下午
 */
public class User {

    private String name;

    private int age;

    private Date date;

    private HashMap<String,String> hashMap;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        Date date = new Date();
        Date before =  new Date(date.getTime() - 1000L);
        user1.setDate(date);
        user1.setName("1");
        user2.setDate(before);
        user2.setName("2");

        List<User> users = Arrays.asList(user1, user2);
        users = users.stream().sorted(Comparator.comparing(User::getDate)).collect(Collectors.toList());
        users.forEach(System.out::println);
    }
}
