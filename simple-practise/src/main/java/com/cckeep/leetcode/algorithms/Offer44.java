package com.cckeep.leetcode.algorithms;

public class Offer44 {

    public static void main(String[] args) {
        System.out.println(new Offer44().findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        int digit = 1;
        int start = 1;
        int count = 9;
        while(n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }

        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }


}
