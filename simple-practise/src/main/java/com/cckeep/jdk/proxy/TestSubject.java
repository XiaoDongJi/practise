package com.cckeep.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestSubject {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler invocationHandler = new SubjectInvocationHandler(subject);

        Subject s = (Subject)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), subject.getClass().getInterfaces(), invocationHandler);

        s.hello("hehe");

    }





}
