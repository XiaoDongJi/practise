package array;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * @author jixd
 * @Date Created in 2019年01月16日 20:47
 */
public class MaximumSubarray_53 {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        //System.out.println(maxSubArray(arr));


        Set<Long> aa = new HashSet<>();
        aa.add(1000L);
        aa.add(1100L);
        Set<Long> bb = new HashSet<>();
        bb.add(1100L);
        bb.add(1200L);

        Sets.SetView<Long> intersection = Sets.intersection(aa, bb);

        System.out.println(aa.removeAll(intersection));
        System.out.println(aa);


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        List<Integer> integers = list.subList(3, 6);
        //System.out.println(integers);

        Map<Long, Map<Long,List<String>>> testMap = Maps.newHashMap();
        Map<Long,List<String>> chMap = Maps.newHashMap();

        chMap.put(1L,Arrays.asList("a","b","c"));
        chMap.put(2L,Arrays.asList("a","b","c"));
        chMap.put(3L,Arrays.asList("a","b","c"));

        Map<Long,List<String>> ch1Map = Maps.newHashMap();
        ch1Map.put(1L,Arrays.asList("a","b"));
        ch1Map.put(2L,Arrays.asList("a","b","c"));
        ch1Map.put(3L,Arrays.asList("a","b","c"));

        testMap.put(1L,ch1Map);
        testMap.put(2L,chMap);

        long count = ch1Map.values().stream().flatMap(a -> a.stream()).count();
        System.out.println(count);

        Long cc = testMap.values().stream().map(a -> a.values()).flatMap(a -> a.stream()).flatMap(b->b.stream()).count();
        System.out.println(cc);

        Long p1 = testMap.values().stream().map(a -> a.values()).flatMap(b -> b.stream()).count();
        List<Integer> collect = testMap.values().stream().flatMap(a -> IntStream.of(a.values().size()).boxed()).collect(Collectors.toList());
        System.out.println(p1);

    }


    /**
     * 连续的和相加   查看和比当前值比较大于还是小于 如果是大于 则从新当前值开始
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}
