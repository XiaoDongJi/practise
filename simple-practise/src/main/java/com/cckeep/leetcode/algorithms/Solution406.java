package com.cckeep.leetcode.algorithms;

import java.util.*;

/**
 * @author: jixd
 * @date: 2020/10/17 1:13 下午
 */
public class Solution406 {

    public static void main(String[] args) {

        System.out.println(1L << 10L);
        System.out.println(ArrayList.class.isAssignableFrom(List.class));
        System.out.println(List.class.isAssignableFrom(ArrayList.class));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }

}
