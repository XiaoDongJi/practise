package com.cckeep.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序算法：
 *  对于给定的一组记录，选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,
 *   一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分，直到序列中的所有记录均有序为止
 * 时间复杂度：
 * 最坏情况，选取得基准值 最大或者最小时间复杂度为 O(n²)
 * 最好情况，选取中间值，时间复杂度 O(Nlogn)
 *
 */
public class QuickSort {


    public static void main(String[] args) {

        int[] arr = {2,22,4,25,6,16};


        sort(arr,0,arr.length - 1);

        System.out.println("排序后：arr=" + Arrays.toString(arr));

    }


    private static void sort(int[] arr, int begin, int end) {
        if (begin > end){
            return;
        }
        int low = begin, hight = end;

        // 将第一个值作为快排序的分界值
        int pivot = arr[low];
        while (low < hight) {
            // 如果两个游标没有交集，或者后面一直大于或等于分界值就一直向前移动
            while (low < hight && arr[hight] >= pivot) {
                --hight;
            }
            //高位赋值给低位
            arr[low] = arr[hight];
            // 如果两个游标没有交集，或者前面是小于或等于分界值，就一直向后头移动
            while (low < hight && arr[low] <= pivot) {
                ++low;
            }
            //高位赋值给低位
            arr[hight] = arr[low];
        }

        // 将临界值赋值给游标的交集的地方
        arr[low] = pivot;
        // 递归排序游标的左边
        sort(arr, begin, hight - 1);

        // 递归排序游标的右边
        sort(arr, low + 1, end);


    }


}
