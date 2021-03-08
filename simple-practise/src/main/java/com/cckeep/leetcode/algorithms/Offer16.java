package com.cckeep.leetcode.algorithms;

/**
 *
 * 剑指 Offer 16. 数值的整数次方
 * @author: jixd
 * @date: 2021/3/7 10:51 上午
 */
public class Offer16 {


    public static void main(String[] args) {
        System.out.println(new Offer16().myPow(2,-10));
    }


    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        long b = n;
        double res = 1d;
        if(b < 0){
            b = -b;
            x = 1 / x;
        }
        while(b > 0){
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
