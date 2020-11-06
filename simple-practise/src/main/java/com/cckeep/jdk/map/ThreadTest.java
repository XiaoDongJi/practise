package com.cckeep.jdk.map;

/**
 * @author: jixd
 * @date: 2020/11/6 6:23 下午
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {


        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println("aaaa");
            }
        };
        t.start();
        //t.join();
    }

}
