import java.util.Arrays;

/**
 *
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 *
 *
 * @author jixd
 * @Date Created in 2019年01月15日 09:56
 */
public class ThreeNumbers_628 {

    public static void main(String[] args) {
        int[] aa = new int[]{-4,-3,-2,-1,60};
        System.out.println(maximumProduct(aa));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        System.out.println(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }


}
