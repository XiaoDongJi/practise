package com.cckeep.leetcode.algorithms;

/**
 * 5.最长回文子串
 * <p>给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000</p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * <p>
 * <p>
 * 解题思路，循环字符串，中中间值开始算，两边字符对称
 * 1.中间1个值 两边对称
 * 2.中间值都相同，中间几个值一样
 *
 * @author jixd
 * @Date Created in 2018年08月28日 14:09
 */
public class Solution5 {


    public static void main(String[] args) {

        String babad = new Solution5().longestPalindrome("babad");
        System.out.println(babad);

    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i + k < n; ++i) {
                int j = i + k;
                if (k == 0) {
                    dp[i][j] = true;
                } else if (k == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && k + 1 > ans.length()) {
                    ans = s.substring(i, i + k + 1);
                }
            }
        }
        return ans;
    }


}
