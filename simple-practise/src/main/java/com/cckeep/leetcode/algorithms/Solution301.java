package com.cckeep.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 移除无效括号所有组合
 * @author: jixd
 * @date: 2021/2/25 9:11 上午
 */
public class Solution301 {

    private int len;
    private char[] chars;

    public static void main(String[] args) {
        System.out.println(new Solution301().removeInvalidParentheses("(a)())()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        len = s.length();
        chars = s.toCharArray();
        int leftRemove = 0;
        int rightRemove = 0;
        for(char ch : chars){
            if(ch == '('){
                leftRemove++;
            }else if (ch == ')'){
                if(leftRemove == 0){
                    rightRemove++;
                }else {
                    leftRemove--;
                }
            }
        }

        Set<String> set = new HashSet<>();
        StringBuffer path = new StringBuffer();

        dfs(0,0,0,leftRemove,rightRemove,path,set);

        return new ArrayList<>(set);
    }

    /**
     * dfs
     * @param index
     * @param leftCount
     * @param rightCount
     * @param leftRemove
     * @param rightRemove
     * @param path
     * @param set
     */
    private void dfs (int index,int leftCount,int rightCount,int leftRemove,int rightRemove,StringBuffer path,Set<String> set) {
        if (len == index) {
            if (leftRemove == 0 && rightRemove == 0) {
                set.add(path.toString());
            }
            return;
        }

        char ch = chars[index];
        if (ch == '(' && leftRemove > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, path, set);
        } else if (ch == ')' && rightRemove > 0) {
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, path, set);
        }

        path.append(ch);
        if (ch != '(' && ch != ')') {
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove, path, set);
        } else if (ch == '(') {
            dfs(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, path, set);
        } else if (ch == ')') {
            if (rightCount < leftCount) {
                dfs(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, path, set);
            }
        }
        path.deleteCharAt(path.length() - 1);

    }

}
