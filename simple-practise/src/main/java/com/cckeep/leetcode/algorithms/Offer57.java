package com.cckeep.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jixd
 * @date: 2021/2/28 4:04 下午
 */
public class Offer57 {

    public static void main(String[] args) {
        int[][] continuousSequence = new Offer57().findContinuousSequence(6);
        System.out.println(Arrays.toString(continuousSequence));
    }


    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for(int i = 1,j = 2;i < j;){
            int sum = (i + j) * (j - i + 1) / 2;
            if(sum == target){
                int[] tmp = new int[j - i + 1];
                for(int k = i;k <= j;k++){
                    tmp[k - i] = k;
                }
                list.add(tmp);
                i++;
            }else if (sum > target){
                i++;
            }else{
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
