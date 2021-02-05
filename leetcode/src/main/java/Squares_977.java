import java.util.Arrays;

/**
 * <p>Squares of a Sorted Array</p>
 *
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * @author jixd
 * @Date Created in 2019年02月18日 14:42
 */
public class Squares_977 {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0){
            return A;
        }
        for (int i = 0;i<A.length - 1;i++){
                A[i] =  (int)Math.pow(A[i],2);
        }
        Arrays.sort(A);
        return A;
    }

}
