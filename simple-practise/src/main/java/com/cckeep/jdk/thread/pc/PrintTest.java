package com.cckeep.jdk.thread.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: jixd
 * @date: 2021/3/8 8:53 上午
 */
public class PrintTest implements Runnable {


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition aCondition = lock.newCondition();
        Condition bCondition = lock.newCondition();
        Condition cCondition = lock.newCondition();

        Thread printerA = new Thread(new PrintTest(lock,aCondition,bCondition,'A'));
        Thread printerB = new Thread(new PrintTest(lock,bCondition,cCondition,'B'));
        Thread printerC = new Thread(new PrintTest(lock,cCondition,aCondition,'C'));
        printerA.start();
        printerB.start();
        printerC.start();

    }

    private final ReentrantLock lock;
    private final Condition thisCondition;
    private final Condition nextCondition;
    private char print;

    public PrintTest(ReentrantLock lock, Condition thisCondition, Condition nextCondition, char print){
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.print = print;
    }    @Override
    public void run() {
        lock.lock();
        try{
            for (int i = 0;i < 10;i++){
                System.out.print(print);
                nextCondition.signal();
                this.thisCondition.await();
            }
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }
}
