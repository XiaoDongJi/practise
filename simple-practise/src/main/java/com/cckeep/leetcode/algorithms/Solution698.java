package com.cckeep.leetcode.algorithms;

/**
 * 698. 划分为k个相等的子集
 *
 * @author: jixd
 * @date: 2021/3/5 9:18 上午
 */
public class Solution698 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 3, 5, 2, 1};
        System.out.println(new Solution698().canPartitionKSubsets(arr,4));
    }


    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int target = sum / k;

        int[] bucket = new int[k];
        return backtrace(nums, 0, bucket, target);
    }

    public boolean backtrace(int[] nums, int index, int[] bucket, int target) {
        if (nums.length == index) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) return false;
            }
            return true;
        }
        for(int i = 0;i < bucket.length;i++){
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            bucket[i] += nums[index];
            if (backtrace(nums,index + 1,bucket,target)){
                return true;
            }
            bucket[i] -= nums[index];
        }
        return false;
    }


}
