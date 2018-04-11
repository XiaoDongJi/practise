package com.cckeep.jdk.thread.pc;

/**
 * 创建(new)、就绪(runnable)、运行(running)、阻塞(blocked)、time waiting、waiting、消亡（dead）
 */
public class Test {

    public static void main(String[] args) {
        Storage storage = new Storage();

        for (int i = 0;i<10;i++){
            new Producer("生产者_"+i,10,storage).start();
            new Consumer("消费者_"+i,10,storage).start();
        }

    }


}
