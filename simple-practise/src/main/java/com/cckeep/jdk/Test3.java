package com.cckeep.jdk;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test3 {

    public static void main(String[] args) {

        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println(findK(arr,2));
    }

    public static int findK(int[] arr,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for(int i = 0;i < arr.length;i++){
            if(queue.size() < k){
                queue.add(arr[i]);
            }else{
                if(queue.peek() < arr[i]){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }



        for(int i = 1;i < k - 2;i++){
            queue.poll();
        }
        return queue.peek();
    }
}
