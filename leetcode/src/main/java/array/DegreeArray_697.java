package array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 *
 *
 */
public class DegreeArray_697 {
    /**
     *
     * 3个map,设置左边第一个找到元素的位置，设置最后一个出现的位置，设置元素出现的个数
     *
     * 最终找到最大的count的key值，然后找到差值 返回
     *
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> left = new HashMap<>(),right = new HashMap<>(),count = new HashMap<>();
        for (int i = 0;i < nums.length; i++){
            if (left.get(nums[i]) == null) left.put(nums[i],i);
            right.put(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i],0) + 1);
        }

        int ans = nums.length;
        Integer degree= Collections.max(count.values());
        for (int key : count.keySet()){
            if (count.get(key) == degree){
                ans =  Math.min(ans,right.get(key) - left.get(key) + 1);
            }
        }
        return ans;
    }

}
