package com.cckeep.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        new Solution3().lengthOfLongestSubstring("abcba");
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int res = 0,left = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res,i - left + 1);
        }

        return res;
    }

}
