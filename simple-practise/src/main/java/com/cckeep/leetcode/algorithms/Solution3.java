package com.cckeep.leetcode.algorithms;

import java.util.HashMap;

/**
 * @author: jixd
 * @date: 2020/11/11 1:19 下午
 */
public class Solution3 {

    public static void main(String[] args) {

        System.out.println(new Solution3().lengthOfLongestSubstring("abcabcbb"));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


}
