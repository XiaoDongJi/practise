package com.cckeep.jdk.thread.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCDemo {

    private static volatile int count = 0;
    private static int Full = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition notEmpty = lock.newCondition();
    private static Condition notFull = lock.newCondition();

    public static void main(String[] args) {
        for (int i = 0;i < 20;i++){
            new Producer().start();
        }
        for(int i = 0;i < 20;i++){
            new Consumer().start();
        }


    }



    public static class Producer extends Thread{
        @Override
        public void run() {
            lock.lock();
            try{
                if(count == 10){
                    System.out.println("生产者阻塞");
                    notEmpty.await();
                }
                count++;
                System.out.println("生产者 "+count);
                notFull.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }
    }


    public static class Consumer extends Thread{
        @Override
        public void run() {
            lock.lock();
            try{
                if(count == 0){
                    System.out.println("消费者阻塞");
                    notFull.await();
                }
                count--;
                System.out.println("消费者 " + count);
                notEmpty.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }

        }
    }
}
