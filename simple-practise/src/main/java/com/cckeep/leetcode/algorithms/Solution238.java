package com.cckeep.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2020/10/14 10:48 上午
 */
public class Solution238 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,7};
        int[] ints = new Solution238().productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }


    public int[] productExceptSelf(int[] nums){
        int[] res = new int[nums.length];
        int p = 1, q = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }

}
