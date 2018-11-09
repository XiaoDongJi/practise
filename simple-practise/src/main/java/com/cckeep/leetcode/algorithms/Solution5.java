package com.cckeep.leetcode.algorithms;

/**
 *
 *  5.最长回文子串
 * <p>给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000</p>
 *  输入: "babad"
 *  输出: "bab"
 *  注意: "aba"也是一个有效答案。
 *
 *
 *  解题思路，循环字符串，中中间值开始算，两边字符对称
 *  1.中间1个值 两边对称
 *  2.中间值都相同，中间几个值一样
 * @author jixd
 * @Date Created in 2018年08月28日 14:09
 */
public class Solution5 {

    public static void main(String[] args) {

        Solution5 solution5 = new Solution5();
        String cbbd = solution5.longestPalindrome("babad");
        System.out.println(cbbd);
    }


    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }

    }
}
