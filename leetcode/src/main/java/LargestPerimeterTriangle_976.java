import java.util.Arrays;

/**
 *  Largest Perimeter Triangle
 *
 *  Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 *
 * If it is impossible to form any triangle of non-zero area, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [2,1,2]
 * Output: 5
 * Example 2:
 *
 * Input: [1,2,1]
 * Output: 0
 * Example 3:
 *
 * Input: [3,2,3,4]
 * Output: 10
 * Example 4:
 *
 * Input: [3,6,2,3]
 * Output: 8
 *
 * @author jixd
 * @Date Created in 2019年01月14日 20:06
 */
public class LargestPerimeterTriangle_976 {

    /**
     * 1.先排序
     * 2.后面两位的和大于前一位的和 就可以 返回
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        if (A.length < 3){
            return 0;
        }

        for (int i = A.length -1; i > 0; i--){
            if (i - 2 < 0){
                break;
            }
            if (A[i] > (A[i-1] + A[i - 2])){
                return A[i] + A[i - 1] + A[i - 2];
            }
        }

        return 0;
    }
}
