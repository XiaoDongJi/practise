package com.cckeep.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: jixd
 * @date: 2020/11/5 6:05 下午
 */
public class PCModel {

    private Deque<Integer> deque = new LinkedList<>();
    private static Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition notFull = lock.newCondition();

    class Produce extends Thread{

    }


}
