package com.cckeep.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * 最好情况时间复杂度 O(n)
 * 平均时间复杂度 O(n²)
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {2,22,4,25,6,16};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void sort(int[] arr){
        for (int i = 0;i < arr.length; i++){
            for (int j = 0;j < arr.length - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
