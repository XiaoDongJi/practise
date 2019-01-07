package com.cckeep.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestExecutorService {


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0;i<4;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(111);
                }
            });
        }



        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);




        executorService.shutdown();
        System.out.println(executorService.isShutdown());

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(222);
            }
        });

    }

}
