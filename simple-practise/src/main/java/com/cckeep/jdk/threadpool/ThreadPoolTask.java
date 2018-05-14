package com.cckeep.jdk.threadpool;

import java.util.concurrent.CountDownLatch;

/**
 * 测试线程池 任务
 */
public class ThreadPoolTask implements Runnable{

    private String taskName;

    private CountDownLatch latch;

    public ThreadPoolTask(String taskName,CountDownLatch latch) {
        this.taskName = taskName;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("执行任务:"+taskName+",使用线程:"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
