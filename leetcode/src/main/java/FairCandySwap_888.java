import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 *
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 *
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 *
 * Example 1:
 *
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 *
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 *
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 *
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 * 交换糖果  只能交换各自的一个
 */
public class FairCandySwap_888 {


    /**
     * 笨方法   先求出总和/2 获取平均以后的结果值,   遍历其中一个数组.替换其中一个值，总数想相减获得的值在另一个数组出现，则是要替换的
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sum = 0;
        int sumA = 0;
        sumA = Arrays.stream(A).sum();
        sum += sumA;
        sum += Arrays.stream(B).sum();
        sum = sum / 2;

        List<Integer> collect = Arrays.stream(B).boxed().collect(Collectors.toList());
        for (int i = 0; i < A.length; i++) {
            int temp = sum - (sumA - A[i]);
            if (collect.contains(temp)){
                res[0] = A[i];
                res[1] = temp;
            }
        }

        return res;
    }

    /**
     * 数学公式
     *
     * S(A) -x + y = S(B) - y + x
     *
     * y = x + (S(B) - S(A)) / 2
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap_1(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x: A) sa += x;
        for (int x: B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet();
        for (int x: B) setB.add(x);

        for (int x: A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }



}
