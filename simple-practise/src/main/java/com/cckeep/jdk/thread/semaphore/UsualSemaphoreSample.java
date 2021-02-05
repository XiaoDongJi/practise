package com.cckeep.jdk.thread.semaphore;


import java.util.concurrent.Semaphore;

public class UsualSemaphoreSample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(5);
        System.out.println("action go !");
        for (int i = 0;i< 10;i++){
            Thread t = new Thread(new SemaphoreWork(semaphore));
            t.start();
        }

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

            } finally {
                log("released a permit!");
                semaphore.release();
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
