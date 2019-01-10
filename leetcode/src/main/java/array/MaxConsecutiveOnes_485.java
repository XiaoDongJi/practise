package array;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes_485 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int curr = 0;
        for (int num : nums){
            if (num == 1){
                ++curr;
            }else{
                if (curr > max){
                    max = curr;
                }
                curr = 0;
            }
        }
        if (curr > max){
            max = curr;
        }

        return max;
    }
}
