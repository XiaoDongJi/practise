package array;

import java.util.Arrays;

/**
 * <p>724. Find Pivot Index</p>
 *Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 * Example 1:
 *
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *
 *
 * Example 2:
 *
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * @author jixd
 * @Date Created in 2019年02月18日 16:15
 */
public class FindPivotIndex_724 {
    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int presum = 0;
        for (int i = 0;i< nums.length;i++){
            if ((sum - nums[i]) %2 == 0){
                int halfSum = (sum - nums[i] )/ 2;
                if (presum == halfSum){
                    return i;
                }
            }
            presum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] aa = new int[]{1,7,3,6,5,6};
        pivotIndex(aa);
    }

}
