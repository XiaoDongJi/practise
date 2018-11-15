package com.cckeep.zookeeper.curator.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * 分布式锁
 */
public class RecipeLock {

    public static String lockPath = "/curator_lock";

    final static CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
                                                .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

    public static void main(String[] args) {
        client.start();
        final InterProcessMutex lock = new InterProcessMutex(client,lockPath);
        final CountDownLatch downLatch = new CountDownLatch(1);
        for (int i = 0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        try {
                            lock.acquire();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Thread.sleep(10000);
                        downLatch.await();
                        lock.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(LocalDateTime.now().getNano());
                }
            }).start();
        }
        downLatch.countDown();

    }

}
