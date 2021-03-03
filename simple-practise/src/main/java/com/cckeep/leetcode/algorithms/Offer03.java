package com.cckeep.leetcode.algorithms;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * @author: jixd
 * @date: 2021/2/28 4:42 下午
 */
public class Offer03 {

    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] == i){
                i++;
                continue;
            }
            if(nums[i] == nums[nums[i]]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }

        return -1;
    }
}
