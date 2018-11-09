package com.cckeep.jdk.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) {
        ServiceLoader<Human> service = ServiceLoader.load(Human.class);
        Iterator<Human> iterator = service.iterator();
        while (iterator.hasNext()){
            Human next = iterator.next();
            next.say();
        }
    }

}
