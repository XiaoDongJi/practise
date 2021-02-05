package com.dd;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringJoiner;

/**
 * @author: jixd
 * @date: 2020/12/2 4:12 下午
 */
public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }

}
