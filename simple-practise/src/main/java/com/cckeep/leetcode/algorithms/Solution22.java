package com.cckeep.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jixd
 * @date: 2020/10/12 5:32 下午
 */
public class Solution22 {

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }

    public void backTrack(List<String> ans,StringBuilder sb,int open,int close,int max){
        if(sb.length() == 2 * max){
            ans.add(sb.toString());
            return;
        }
        if(open < max){
            sb.append("(");
            backTrack(ans,sb,open + 1,close,max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(")");
            backTrack(ans,sb,open,close + 1,max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
