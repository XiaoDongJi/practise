package com.cckeep.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 *你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *给定 nums = [2, 7, 11, 15], target = 9
 *因为 nums[0] + nums[1] = 2 + 7 = 9
 *所以返回 [0, 1]
 * @author jixd
 * @Date Created in 2018年08月01日 17:47
 */
public class TwoSum1 {

    public static void main(String[] args) {

    }


    /**
     *
     * 暴力法
     * 遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素
     * 时间复杂度：时间复杂度为 O(n^2）
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0;i<nums.length - 1;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("参数错误");
    }

    /**
     * 链表法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍hash表
     *  时间复杂度 O（n）
     *  空间复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
