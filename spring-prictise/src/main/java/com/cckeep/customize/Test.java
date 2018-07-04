package com.cckeep.customize;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        User user = (User)context.getBean("userTest");

        System.out.printf("email:%s, name:%s",user.getEmail(),user.getUserName());

    }
}
