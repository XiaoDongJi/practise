package com.cckeep.algorithm.sort;

import java.util.Arrays;

public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {2, 22, 4, 25, 6, 16};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            for(int j = i;j > 0 && arr[j] < arr[j - 1];j--){
                swap(arr,j,j - 1);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
