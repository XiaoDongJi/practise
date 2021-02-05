package com.cckeep.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.开始的空格
 * 2.幂符号前的正负号
 * 3.小数点前的数字
 * 4.小数点、小数点后的数字
 * 5.当小数点前为空格时，小数点、小数点后的数字
 * 6.幂符号
 * 7.幂符号后的正负号
 * 8.幂符号后的数字
 * 9.结尾的空格
 *
 * 数字代表 d
 * 幂符号 e
 * 小数点 .
 * 正负号 s
 */
public class Offer20 {



    public static void main(String[] args) {

    }

    public boolean isNumber(String s){
        Map[] states = {
                new HashMap<Character,Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Character,Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Character,Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Character,Integer>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Character,Integer>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Character,Integer>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Character,Integer>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Character,Integer>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

}
