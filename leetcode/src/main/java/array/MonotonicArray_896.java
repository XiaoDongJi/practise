package array;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 */
public class MonotonicArray_896 {

    //[1,3,2]
    //[11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5]
    public boolean isMonotonic(int[] A) {

        if (A.length == 1){
            return true;
        }
        int forward = A[0];
        int flag = 0;
        for (int i = 1; i < A.length; i++) {
            int diff = forward - A[i];
            if (diff == 0){
                continue;
            }
            if (diff < 0 && flag > 0){
                return false;
            }
            if (diff > 0 && flag < 0){
                return false;
            }
            flag = diff;
            forward = A[i];
        }
        return true;
    }


    /**
     *
     *
     * 存储比较结果  如果比较结果不相同 且与上次不同 则返回false
     * @param A
     * @return
     */
    public boolean isMonotonic_2(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }


}
