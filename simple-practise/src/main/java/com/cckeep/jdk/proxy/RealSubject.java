package com.cckeep.jdk.proxy;

public class RealSubject implements Subject{
    @Override
    public void rent() {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String name) {
        System.out.println("hello :" + name);
    }


}
