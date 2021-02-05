package com.cckeep.jdk.thread.semaphore;


import java.util.concurrent.Semaphore;

public class UnNormalSemaphoreSample {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(0);
        System.out.println("Action...GO!");
        for (int i = 0;i< 10;i++){
            Thread t = new Thread(new SemaphoreWork(semaphore));
            t.start();
        }
        semaphore.release(5);
        while (semaphore.availablePermits()!=0) {
            Thread.sleep(100L);
        }
        System.out.println("Action...GO again!");
        semaphore.release(5);

    }


    static class SemaphoreWork implements Runnable {
        private String name;

        private Semaphore semaphore;

        public SemaphoreWork(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                log("is waiting for a permit!");
                semaphore.acquire();
                log("acquired a permit! ");
            } catch (Exception e) {

            }

        }

        private void log(String msg) {
            if (name == null) {
                name = Thread.currentThread().getName();
            }
            System.out.println(name + " " + msg);
        }
    }

}
