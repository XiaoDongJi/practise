package com.cckeep.algorithm.sort;

import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2021/1/8 2:18 下午
 */
public class QuickSort2 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,8,2,3,6};
        new QuickSort2().sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
        //System.out.println(new QuickSort2().findK(arr,4));

    }


    public int findK(int[] nums,int k){
        int lo = 0,hi = nums.length - 1;
        k = nums.length - k;
        while(lo <= hi){
            int p = partition(nums,lo,hi);
            if(p > k){
                hi = p - 1;
            }else if (p < k){
                lo = p + 1;
            }else{
                return nums[p];
            }
        }
        return -1;
    }


    public void sort(int[] nums,int lo,int hi){
        if(lo >= hi) return;
        int p = partition(nums,lo,hi);
        sort(nums,lo,p - 1);
        sort(nums,p + 1,hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi){
            return lo;
        }
        int pivot = nums[lo];
        int i = lo,j = hi + 1;
        while(true){
            while(nums[++i] < pivot){
                if(i == hi) break;
            }
            while(nums[--j] > pivot){
                if(j == lo) break;;
            }
            if (i >= j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,j,lo);
        return j;
    }


    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
