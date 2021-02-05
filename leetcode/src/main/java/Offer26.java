/**
 * @author: jixd
 * @date: 2021/1/15 1:19 下午
 */
public class Offer26 {

    public static void main(String[] args) {
        new Offer26().translateNum(25);
    }
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2;i <= str.length();i++){
            String sub = str.substring(i - 2,i);
            int c = (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
