import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2021/1/13 9:44 上午
 */
public class Offer66 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        int[] ints = constructArr(a);
        System.out.println(Arrays.toString(ints));

    }


    public static int[] constructArr(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = 1;
        for(int i = 1;i < a.length;i++){
            dp[i] = dp[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for(int i = a.length - 2;i >= 0;i--){
            tmp *= a[i + 1];
            dp[i] *= tmp;
        }
        return dp;
    }

}
