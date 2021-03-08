package com.cckeep.jdk.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: jixd
 * @date: 2021/3/7 12:11 下午
 */
public class ThreadLocalTest {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }


    public static void main(String[] args) {


        for (int i = 0 ;i < 4;i ++){
            new Thread(() -> {
                System.out.println(get());}).start();
        }
        System.out.println(get());


    }


}
