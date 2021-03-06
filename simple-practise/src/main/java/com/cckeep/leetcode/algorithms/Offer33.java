package com.cckeep.leetcode.algorithms;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *
 * @author: jixd
 * @date: 2021/3/6 3:52 下午
 */
public class Offer33 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 6, 12, 16, 14, 10};
        System.out.println(new Offer33().verifyPostorder(arr));
    }

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length - 1);
    }


    public boolean verify(int[] postorder, int i, int j){
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;

        return p == j && verify(postorder,i,m - 1) && verify(postorder,m,j - 1);
    }

}
