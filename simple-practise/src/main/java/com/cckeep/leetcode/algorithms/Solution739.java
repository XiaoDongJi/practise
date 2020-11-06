package com.cckeep.leetcode.algorithms;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: jixd
 * @date: 2020/11/6 9:02 上午
 */
public class Solution739 {

    public static void main(String[] args) {
        int[] t = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(t)));;

    }


    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.add(i);

        }
        return result;
    }

}
