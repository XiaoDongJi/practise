package com.cckeep.leetcode.algorithms;

/**
 *
 *
 * 剑指 Offer 49. 丑数
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @author: jixd
 * @date: 2021/3/3 8:35 上午
 */
public class Offer49 {

    public static void main(String[] args) {
        System.out.println(new Offer49().nthUglyNumber(5));
    }


    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0,b = 0,c = 0;
        for(int i = 1;i < n;i++){
            int va = dp[a] * 2,vb = dp[b] * 3,vc = dp[c] * 5;
            int val = Math.min(va,Math.min(vb,vc));
            if(val == va) a++;
            if(val == vb) b++;
            if(val == vc) c++;
            dp[i] = val;
        }
        return dp[n - 1];
    }



}
