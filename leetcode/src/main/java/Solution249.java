import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2021/1/29 4:05 下午
 */
public class Solution249 {

    public static void main(String[] args) {

    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int max_index = (int)Math.sqrt(n) + 1;
        int[] nums = new int[max_index];
        for(int i = 1; i < max_index; i++){
            nums[i] = i * i;
        }

        for(int i = 1; i <= n;i++){
            for(int j = 1 ;j < nums.length;j++){
                if(i >= nums[j]){
                    dp[i] = Math.min(dp[i],dp[i - nums[j]] + 1);
                }
            }
        }
        return dp[n];
    }

}
