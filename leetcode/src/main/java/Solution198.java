/**
 * @author: jixd
 * @date: 2021/1/30 11:52 上午
 */
public class Solution198 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        System.out.println(new Solution198().rob(arr));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < n; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        }
        return dp[n - 1];
    }
}
