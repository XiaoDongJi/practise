package com.cckeep.jdk.threadpool.schedule;

import java.util.concurrent.*;

public class ScheduleTest {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"rabbit_connection_recovery");
            }
        });

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ ":111111");
            }
        }, 10, 1000, TimeUnit.MILLISECONDS);

        Thread.sleep(10000);
        System.out.println("中断");
        scheduledFuture.cancel(true);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ ":222222");
            }
        }, 10, 1000, TimeUnit.MILLISECONDS);

    }


}
