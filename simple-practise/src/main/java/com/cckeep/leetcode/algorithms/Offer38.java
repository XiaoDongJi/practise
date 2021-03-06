package com.cckeep.leetcode.algorithms;

import java.util.*;

/**
 *
 * 剑指 Offer 38. 字符串的排列
 * @author: jixd
 * @date: 2021/3/5 10:53 上午
 */
public class Offer38 {

    public static void main(String[] args) {
        String str = "abc";
        String[] permutation = new Offer38().permutation(str);
        System.out.println(Arrays.toString(permutation));
    }

    List<String> list = new ArrayList<>();
    public String[] permutation (String s) {
        char[] chars = s.toCharArray();
        dfs(chars,0);
        String[] ans = new String[list.size()];
        for(int i = 0;i < list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void dfs(char[] chars,int index){
        if(chars.length == index){
            list.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index;i < chars.length;i++){
            if (set.contains(chars[i])) continue;
            swap(chars,i,index);
            dfs(chars,index + 1);
            swap(chars,i,index);
            set.add(chars[i]);
        }

    }

    public void swap(char[] chs,int i,int j){
        char ch = chs[i];
        chs[i] = chs[j];
        chs[j] = ch;
    }


}
