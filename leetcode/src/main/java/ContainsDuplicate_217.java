import java.util.*;

/**
 *
 * title:Contains Duplicate
 *
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 */
public class ContainsDuplicate_217 {

    /**
     * 是否有重复元素
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums){
            set.add(a);
        }
        if (set.size() != nums.length){
            return true;
        }else {
            return false;
        }
    }



    public boolean containsDuplicate1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i],i);
            }

        }
        return false;
    }

    /**
     * 排序 相同的元素一定挨着
     *
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return true;
            }

        }
        return false;
    }


}
