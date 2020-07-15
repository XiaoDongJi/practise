package com.cckeep.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeadLockDemo extends Thread{

    private String lockA;
    private String lockB;

    public DeadLockDemo(String name,String lockA,String lockB){
        super(name);
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {

        synchronized (lockA){
            System.out.println(getName() + " get lock : "+ lockA);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(getName() + " get lock: " + lockB);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
                if (deadlockedThreads != null){
                    ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(deadlockedThreads);
                    for (ThreadInfo t : threadInfos){
                        System.out.println(t.getThreadName());
                    }
                }
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(runnable,5,3, TimeUnit.SECONDS);

        String lockA = "lockA";
        String lockB = "lockB";

        DeadLockDemo t1 = new DeadLockDemo("one",lockA,lockB);
        DeadLockDemo t2 = new DeadLockDemo("two",lockB,lockA);

        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }
}
