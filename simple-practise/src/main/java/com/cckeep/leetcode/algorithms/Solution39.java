package com.cckeep.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: jixd
 * @date: 2020/10/13 7:24 下午
 */
public class Solution39 {

    public static void main(String[] args) {
        int[] c = new int[]{2,3,6,7};
        List<List<Integer>> lists = new Solution39().combinationSum(c, 7);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        backTracke(candidates,target,ans,tmp,0);
        return ans;
    }

    public void backTracke(int[] candidates,int target,List<List<Integer>> ans, LinkedList<Integer> tmp,int idx){
        if(idx == candidates.length){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList(tmp));
            return;
        }
        backTracke(candidates,target,ans,tmp,idx + 1);
        if(target - candidates[idx] >= 0){
            tmp.add(candidates[idx]);
            backTracke(candidates,target - candidates[idx],ans,tmp,idx);
            tmp.removeLast();
        }
    }

}
