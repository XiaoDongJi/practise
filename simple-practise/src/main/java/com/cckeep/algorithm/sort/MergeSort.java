package com.cckeep.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author: jixd
 * @date: 2021/1/9 10:09 上午
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,8,2,3,6};
        new MergeSort().sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public void sort(int[] nums,int lo,int hi){
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        sort(nums,lo,mid);
        sort(nums,mid + 1,hi);
        merge(nums,lo,mid,hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int[] tmp = new int[hi - lo + 1];
        int i = lo;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= hi){
            if (nums[i] < nums[j]){
                tmp[k++] = nums[i++];
            }else{
                tmp[k++] = nums[j++];
            }
        }
        while(i <= mid){
            tmp[k++] = nums[i++];
        }
        while(j <= hi){
            tmp[k++] = nums[j++];
        }
        for (int x = 0; x < tmp.length;x++){
            nums[lo + x] = tmp[x];
        }
    }

}
