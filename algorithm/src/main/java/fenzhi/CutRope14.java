package fenzhi;

/**
 * @author: jixd
 * @date: 2020/10/4 11:13 上午
 */
public class CutRope14 {

    public static void main(String[] args) {
        System.out.println(strToInt("42"));
    }

    public  static  int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;
        int i = 1, sin = 1, res = 0, bin = Integer.MAX_VALUE / 10;

        if (c[0] == '-') sin = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > bin || res == bin && c[j] > '7') return sin == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            res = res * 10 + (c[j] - '0');
        }
        return sin * res;

    }

}
