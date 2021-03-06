package com.cckeep.leetcode.algorithms;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 *
 * @author: jixd
 * @date: 2021/3/5 5:57 下午
 */
public class Offer46 {


    public static void main(String[] args) {
        System.out.println(new Offer46().translateNum(12258));
    }


    public int translateNum(int num) {
        String str = String.valueOf(num);
        int a = 1,b = 1;
        for(int i = 2; i <= str.length();i++){
            String sub = str.substring(i - 2, i);
            int c = (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }



}
