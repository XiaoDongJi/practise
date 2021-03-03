package com.cckeep.leetcode.algorithms;

import java.util.Arrays;

/**
 *
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * @author: jixd
 * @date: 2021/3/2 9:09 上午
 */
public class Offer56 {

    public static void main(String[] args) {
        int[] input = new int[]{2,3,4,4};
        System.out.println(Arrays.toString(new Offer56().singleNumbers(input)));


    }

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        int dev = 1;
        while((res & dev) == 0){
            dev <<= 1;
        }

        int a = 0, b = 0;
        for(int num : nums){
            if((num & dev) == 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }
        return new int[]{a,b};
    }

}
