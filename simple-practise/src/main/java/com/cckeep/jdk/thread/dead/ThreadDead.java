package com.cckeep.jdk.thread.dead;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadDead extends Thread {

    private String first;

    private String second;

    public ThreadDead(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            System.out.println(getName() + ":get lock" + first);
            synchronized (second) {
                System.out.println(getName() + ":get lock" + second);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long[] threadIds = threadMXBean.findDeadlockedThreads();
                if (threadIds != null) {
                    ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadIds);
                    System.out.println("Detected deadlock threads:");
                    for (ThreadInfo threadInfo : threadInfos) {
                        System.out.println(threadInfo.getThreadName());
                    }
                }
            }
        };
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // 稍等5秒，然后每10秒进行一次死锁扫描
        scheduler.scheduleAtFixedRate(runnable, 5L, 10L, TimeUnit.SECONDS);


        String first = "lockA";
        String second = "lockB";
        Thread a = new ThreadDead("ThreadA", first, second);
        Thread b = new ThreadDead("ThreadB", second, first);
        a.start();
        b.start();
        a.join();
        b.join();

    }
}