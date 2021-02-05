package com.cckeep.leetcode.algorithms;

public class Offer67 {

    public static void main(String[] args) {
        System.out.println(new Offer67().strToInt("   -42"));
    }

    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if(chars.length == 0) return 0;
        int res = 0;int bandary = Integer.MAX_VALUE / 10;
        int sign = 1;int i = 1;
        if(chars[0] == '-') sign = -1;
        else if(chars[0] != '+') i -= 1;
        for(int j = i;j < chars.length;j++){
            if(chars[j] < '0' || chars[j] > '9') break;
            if(res > bandary || (res == bandary && chars[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[j] - '0');
        }
        return res * sign;
    }

}
