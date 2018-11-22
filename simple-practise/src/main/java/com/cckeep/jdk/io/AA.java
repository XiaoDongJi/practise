package com.cckeep.jdk.io;

/**
 * <p>TODO</p>
 *
 * @author jixd
 * @Date Created in 2018年11月22日 14:23
 */
public class AA {

    public static void main(String[] args) {
        String str = "死刑现场|1";
        String substring = str.substring(0, str.indexOf("|"));
        System.out.println(substring);
        String str1 = "chinesedemocracy嘿嘿";
        for (int i = 0; i < str1.length();i++){
            char a = str1.charAt(i);
            if (!((a >='1' && a<='9') || (a >= 'a' && a <= 'z'))){
                System.out.println(a);
            }
        }


        char c = '1';
        System.out.println(c == 1);
    }

}
