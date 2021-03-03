package com.cckeep.leetcode.algorithms;

/**
 *
 * 剑指 Offer 42. 连续子数组的最大和
 * @author: jixd
 * @date: 2021/3/1 9:34 上午
 */
public class Offer42 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Offer42().maxSubArray(arr));
    }


    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1;i < nums.length; i++){
            nums[i] += Math.max(nums[i - 1],0);
            res = Math.max(res,nums[i]);
        }
        return res;
    }

}
