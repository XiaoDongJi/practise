package com.cckeep.jdk.thread.pc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 缓存示例
 * 生产者 消费者示例
 * 缓存类
 *
 */
public class Storage {
    /**
     * 最大容量
     */
    private final int MAX_SIZE = 100;

    private final LinkedList<Object> list = new LinkedList<>();

    /**
     * 生产
     * @param num
     */
    public void produce(int num){

        synchronized (list){
            while (list.size() + num > MAX_SIZE){
                System.out.println("超出队列最大限制");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0;i<num;i++){
                list.add(new Object());
            }
            System.out.println(Thread.currentThread().getName()+"-生产产品："+num);
            list.notifyAll();
        }
    }

    public void consume(int num){
        synchronized (list){
            while (list.size() < num){
                System.out.println("库存不足");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0;i<num;i++){
                list.remove();
            }
            System.out.println(Thread.currentThread().getName()+"-消费产品："+num);
            list.notifyAll();
        }
    }
}
