package com.cckeep.leetcode.algorithms.beibao;

/**
 * 416. 分割等和子集
 * @author: jixd
 * @date: 2021/2/11 11:06 上午
 */
public class Solution416 {

    public static void main(String[] args) {
        boolean b = new Solution416().canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }


    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len <= 1) return false;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1;i < nums.length;i++){
            for(int j = 0;j <= target;j++){
                dp[i][j] = dp[i - 1][j];
                if(nums[i] == j){
                    dp[i][j] = true;
                }
                if(nums[i] < j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

}
