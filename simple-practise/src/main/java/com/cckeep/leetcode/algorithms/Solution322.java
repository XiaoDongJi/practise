package com.cckeep.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2020/11/12 9:56 上午
 */
public class Solution322 {

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        System.out.println(new Solution322().coinChange(coins,3));;
    }

    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return amount;
        if(coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    if (dp[i - coin] == Integer.MAX_VALUE) return -1;
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
