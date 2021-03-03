package com.cckeep.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * hard 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * @author: jixd
 * @date: 2021/2/27 11:10 上午
 */
public class Solution76 {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(new Solution76().minWindow(s,t));


    }


    Map<Character,Integer> oriMap = new HashMap<>();
    Map<Character,Integer> ansMap = new HashMap<>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for(int i = 0;i < tLen;i++){
            oriMap.put(t.charAt(i),oriMap.getOrDefault(t.charAt(i),0) + 1);
        }
        int sLen = s.length();
        int l = 0,r = -1;
        int ansLen = Integer.MAX_VALUE,ansL = -1,ansR = -1;
        while(r < sLen){
            ++r;
            if(r < sLen && oriMap.containsKey(s.charAt(r))){
                ansMap.put(s.charAt(r),ansMap.getOrDefault(s.charAt(r),0) + 1);
            }
            while(check() && l <= r){
                if (r - l + 1 < ansLen){
                    ansLen = r - l + 1;
                    ansL = l;
                    ansR = l + ansLen;
                }
                if (oriMap.containsKey(s.charAt(l))){
                    ansMap.put(s.charAt(l),ansMap.getOrDefault(s.charAt(l),0) - 1);
                }
                ++l;
            }

        }
        return ansL == -1 ? "" : s.substring(ansL,ansR);
    }

    public boolean check(){
        for(Map.Entry<Character,Integer> entry : oriMap.entrySet()){
            Character ch = entry.getKey();
            Integer val = entry.getValue();
            if(ansMap.getOrDefault(ch,0) < val){
                return false;
            }
        }
        return true;
    }


}
