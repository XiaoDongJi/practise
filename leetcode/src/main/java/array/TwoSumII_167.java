package array;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 *
 */
public class TwoSumII_167 {

    /**
     * 如果是顺序的话，  两个指针 最左边一个，最右边一个  两边指针的和与target比较，如果和比target大，右边指针--，比target小 左边++
     * 最后总有一组值是相同的
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] rest = new int[2];
        if (numbers == null || numbers.length < 2) return rest;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if (sum == target){
                rest[0] = left + 1;
                rest[1] = right + 1;
                break;
            }else if (sum > target){
                --right;
            }else {
                ++left;
            }
        }
        return rest;
    }
}
