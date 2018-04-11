package com.cckeep.jdk.thread.pc;


public class Consumer extends Thread{

    private int num;
    private Storage storage;

    public Consumer(String name,int num, Storage storage) {
        super(name);
        this.storage = storage;
        this.num = num;
    }

    @Override
    public void run() {
        consumer(num);
    }

    private void consumer(int num) {
        storage.consume(num);
    }
}
