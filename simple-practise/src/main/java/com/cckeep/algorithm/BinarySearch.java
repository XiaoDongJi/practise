package com.cckeep.algorithm;

/**
 *
 * 二分查找 必须数组排好序
 * @author: jixd
 * @date: 2020/11/3 8:59 上午
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,4,5,6,7,8};
        System.out.println(searchRight(arr,3));
    }

    public static int search(int[] arr,int target){
        int pivot = 0,left = 0,right = arr.length - 1;
        while(left <= right){
            pivot = (left + right) / 2;
            if (target < arr[pivot]){
                right = pivot - 1;
            }else if (target > arr[pivot]){
                left = pivot + 1;
            }else{
                return pivot;
            }
        }
        return -1;
    }


    public static int searchLeft(int[] arr,int target){
        int i = 0,j = arr.length;
        while(i < j){
            int m = (i + j) / 2;
            if(arr[m] == target){
                j = m;
            }else if (arr[m] > target){
                j = m;
            }else if (arr[m] < target){
                i = m + 1;
            }
        }
        return i;
    }


    public static int searchRight(int[] arr,int target){
        int i = 0,j = arr.length;
        while(i < j){
            int m = (i + j) / 2;
            if (arr[m] == target){
                i = m + 1;
            }else if (arr[m] < target){
                i = m + 1;
            }else if (arr[m] > target){
                j = m;
            }
        }
        return i;
    }

}
