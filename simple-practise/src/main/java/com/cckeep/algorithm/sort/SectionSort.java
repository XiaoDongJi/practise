package com.cckeep.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕
 */
public class SectionSort {

    public static void main(String[] args) {

        int[] arr = {2, 22, 4, 25, 6, 16};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (i != min) {
                swap(arr,i,min);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
