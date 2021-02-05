/**
 * @author: jixd
 * @date: 2021/1/15 9:46 上午
 */
public class Offer60 {

    public static void main(String[] args) {
        System.out.println(new Offer60().dicesProbability(2));
    }


    public double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];
        for(int i = 1;i <= 6;i++){
            dp[1][i] = 1;
        }
        for(int i = 2;i <= n;i++){
            for(int j = i;j <= 6 * i;j++){
                for(int k = 1; k<= 6;k++){
                    if(j < k) continue;
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        double[] ans = new double[6 * n - n + 1];
        for(int i = n; i <= 6 * n; i++)
            ans[i - n] = ((double)dp[n][i]) / (Math.pow(6,n));
        return ans;

    }
}
