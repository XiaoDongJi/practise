/**
 * 674. Longest Continuous Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * @author jixd
 * @Date Created in 2019年01月16日 20:35
 */
public class LongestContinuousIncreasing_674 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,4,7};
        int[] arr1 = new int[]{2,2,2,2,2};
        System.out.println(findLengthOfLCIS(arr1));

    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int max = 0;
        int index = 1;
        for (int i = 0; i< nums.length -1; i++){
            if (nums[i] < nums[i +1]){
                index ++;
            }else{
                index = 1;
            }
            if (index > max){
                max = index;
            }
        }
        return max;
    }

}
