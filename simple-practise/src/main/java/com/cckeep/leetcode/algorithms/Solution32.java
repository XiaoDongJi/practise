package com.cckeep.leetcode.algorithms;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @author: jixd
 * @date: 2021/2/27 11:40 上午
 */
public class Solution32 {

    public static void main(String[] args) {

        String str1 = "(()";
        String str2 = ")()())";
        String str3 = ")))";

        System.out.println(new Solution32().longestValidParentheses(str1));
        System.out.println(new Solution32().longestValidParentheses(str2));
        System.out.println(new Solution32().longestValidParentheses(str3));

    }


    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(-1);
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                deque.push(i);
            }else{
                deque.pop();
                if(deque.isEmpty()){
                    deque.push(i);
                }else{
                    max = Math.max(max,i - deque.peek());
                }
            }
        }
        return max;
    }

}
