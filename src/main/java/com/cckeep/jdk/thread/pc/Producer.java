package com.cckeep.jdk.thread.pc;

/**
 * 生产者
 */
public class Producer extends Thread{

    private int num;
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    public Producer(String name,int num,Storage storage) {
        super(name);
        this.storage = storage;
        this.num = num;
    }

    @Override
    public void run() {
        produce(num);
    }

    public void produce(int num){
        storage.produce(num);
    }


}
