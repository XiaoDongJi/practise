package com.cckeep.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * @author: jixd
 * @date: 2021/3/6 4:43 下午
 */
public class Offer48 {


    public static void main(String[] args) {
        System.out.println(new Offer48().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i = -1,res = 0;
        for (int j = 0; j < s.length();j++){
            if (map.containsKey(s.charAt(j))){
                //i = map.get(s.charAt(j));
                i = Math.max(map.get(s.charAt(j)),i);
            }
            map.put(s.charAt(j),j);
            res = Math.max(res,j - i);
        }

        return res;
    }

}
