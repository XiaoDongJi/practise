package com.cckeep.leetcode.algorithms;

/**
 * @author: jixd
 * @date: 2020/10/9 5:36 下午
 */
public class Solution283 {

    public static void main(String[] args) {
        int[] p = new int[]{0,1,0,3,12};
        new Solution283().moveZeroes(p);
    }


    public void moveZeroes(int[] nums) {
        //双指针
        int left = 0,right = nums.length - 1;
        while(left < right){
            while(nums[right] == 0) right--;
            if(nums[left] == 0){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                right--;
            }
            left++;
        }
    }

}
