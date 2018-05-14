package com.cckeep.jdk.threadpool;

import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class ThreadPoolEx {


    private final ThreadPoolExecutor threadPoll = new ThreadPoolExecutor(5,5,0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>(),
                                            Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());
    private final CountDownLatch latch = new CountDownLatch(10);

    public void runTask(){
        for (int i = 0;i<10;i++){
            threadPoll.execute(new ThreadPoolTask("task"+i,latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoll.shutdownNow();
    }

    public static void main(String[] args) {
        ThreadPoolEx poolEx = new ThreadPoolEx();
        poolEx.runTask();
    }

}
