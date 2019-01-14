package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 */
public class MajorityElement_169 {

    //map计数，然后把value值排序 去最大的一个 然后遍历 map取出key值，后面操作比较麻烦  可以不需要排序
    public int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(nums[i]);
            if (val == null){
                map.put(nums[i],0);
            }else{
                map.put(nums[i],val + 1);
            }
        }

        List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
        Integer max = collect.get(collect.size()-1);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue().intValue() == max.intValue()){
                return entry.getKey();
            }
        }

        return 0;
    }

    /**
     * 后面比较优化方式
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(nums[i]);
            if (val == null){
                map.put(nums[i],0);
            }else{
                map.put(nums[i],val + 1);
            }
        }
        Map.Entry<Integer,Integer> majori = null;

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (majori == null || entry.getValue() > majori.getValue()){
                majori = entry;
            }
        }

        return majori.getKey();
    }

    /**
     * 如果有超过一半数量的值都在数组中，那么中间的脚本一定是数量出现最多的值
     * @param nums
     * @return
     */
    public int majorityElement_2(int[] nums) {

        Arrays.sort(nums);

        return nums[nums.length / 2];


    }


}
