package com.cckeep.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2021/1/31 2:14 下午
 */
public class Solution300 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,9,2,5,3,7,101,18};
        new Solution300().lengthOfLIS(arr);

    }


    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
