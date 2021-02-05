/**
 * @author: jixd
 * @date: 2021/1/23 7:02 下午
 */
public class Offer53 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        new Offer53().maxSubArray(arr);
    }


    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

}
