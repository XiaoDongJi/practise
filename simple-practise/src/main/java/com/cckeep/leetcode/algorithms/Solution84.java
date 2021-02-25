package com.cckeep.leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: jixd
 * @date: 2021/2/24 10:24 上午
 */
public class Solution84 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};

        System.out.println(new Solution84().largestRectangleArea1(arr));
    }

    /**
     * 暴力算法
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = heights[i];
            int left = i;
            while (left > 0 && heights[left - 1] >= cur) {
                left--;
            }
            int right = i;
            while (right < n - 1 && heights[right + 1] >= cur) {
                right++;
            }
            int res = cur * (right - left + 1);
            max = Math.max(res, max);
        }
        return max;
    }

    /**
     * 单调栈
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }

                System.out.println("curIndex = " + i + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }


}
