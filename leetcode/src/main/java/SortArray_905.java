import java.util.Arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 * example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArray_905 {


    //时间复杂度O(NlogN) 空间复杂度 O(N)
    public int[] sortArrayByParity(int[] A) {
        Integer [] B = new Integer[A.length];

        for (int i = 0;i< A.length;i++){
            B[i] = A[i];

        }
        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));

        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
        }


        return A;
    }

    //java 8   simple
    // 时间复杂度O(NlogN) 空间复杂度 O(N)
    public int[] sortArrayByParity1(int[] A) {
        return Arrays.stream(A).boxed().sorted((a,b) -> Integer.compare(a%2,b%2)).mapToInt(i -> i).toArray();
    }

    //
    public int[] sortArrayByParity2(int[] A){
        int[] B = new int[A.length];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                B[index++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2  == 1){
                B[index++] = A[i];
            }
        }

        return A;
    }




}
