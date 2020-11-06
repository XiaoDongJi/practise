package com.cckeep.leetcode.algorithms;

import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2020/10/14 3:48 下午
 */
public class Solution48 {

    public static void main(String[] args) {
        int[][] martix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        print(martix);
        new Solution48().rotate(martix);
        System.out.println("-------------");
        print(martix);
    }


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        System.out.println("--------------");

        print(matrix);
        for (int i = 0; i < n;i++){
            for(int j = 0;j < n / 2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }


    private static void print(int[][] matrix){
        for (int i = 0;i < matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
