package com.cckeep.jdk.thread.pc;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCDemo {

    private static final LinkedList<Integer> list = new LinkedList<>();
    private static final AtomicInteger adder = new AtomicInteger();
    private static int Full = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition notEmpty = lock.newCondition();
    private static Condition notFull = lock.newCondition();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Producer().start();
        }
        for (int i = 0; i < 2; i++) {
            new Consumer().start();
        }


    }


    public static class Producer extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while(true){
                    while (list.size() >= Full) {
                        System.out.println("生产者阻塞" + Thread.currentThread().getId());
                        notFull.await();
                    }
                    list.offer(adder.getAndIncrement());
                    System.out.println("生产者" + Thread.currentThread().getId() + " " + list.peekLast());
                    notEmpty.signal();
                }

            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }


    public static class Consumer extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while(true){
                    while (list.size() == 0) {
                        System.out.println("消费者阻塞" + Thread.currentThread().getId());
                        notEmpty.await();
                    }
                    Integer integer = list.removeFirst();
                    System.out.println("消费者" + Thread.currentThread().getId() + " " + integer);
                    notFull.signal();
                }


            } catch (Exception e) {

            } finally {
                lock.unlock();
            }

        }
    }
}
