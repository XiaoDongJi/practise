package com.cckeep.jdk.thread.semaphore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintLock extends Thread{
    private Lock lock;
    private Condition thisCondition;
    private Condition nextCondition;
    private String ch;

    public PrintLock(String ch,Lock lock,Condition thisCondition,Condition nextCondition){
        this.ch = ch;
        this.lock = lock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
    }

    @Override
    public void run() {
        lock.lock();
        try{
            for (int i = 0;i < 10;i++){
                System.out.print(ch);
                nextCondition.signal();
                thisCondition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        PrintLock A = new PrintLock("A",lock,conditionA,conditionB);
        PrintLock B = new PrintLock("B",lock,conditionB,conditionC);
        PrintLock C = new PrintLock("C",lock,conditionC,conditionA);
        A.start();
        B.start();
        C.start();
    }

}
