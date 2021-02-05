package com.cckeep.jdk;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test2 {

    public static void main(String[] args) {
        System.out.println(subLong("abceafbk"));



    }



    public static String subLong(String str){
        if(str.length() <= 1) return str;
        String ans = "";
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0;j < str.length();j++){
            if(map.containsKey(str.charAt(j))){
                i = Math.min(map.get(str.charAt(j)),i) + 1;
            }
            map.put(str.charAt(j),j);
            String tmp = str.substring(i,j + 1);
            ans = ans.length() > tmp.length() ? ans : tmp;
        }
        return ans;
    }

    public static int findK(int[] arr,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0;i < arr.length;i++){
            if(queue.size() <= k){
                queue.add(arr[i]);
            }else{
                if(queue.peek() < arr[i]){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        return queue.peek();
    }




}
