package array;

/**
 *Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 *
 * Example 1:
 *
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 *
 *
 * Example 2:
 *
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
public class FlippingImage_823 {

    /**
     * 内部水平反转  然后取反
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0;i < A.length;i++){
            int[] B = new int[A[i].length];
            for (int j = 0; j < A[i].length;j++){
                int index = A[i].length -1 - j;
                if (index == j){
                    B[j] = A[i][j];
                }
                B[index] = A[i][j];
            }

            for (int j = 0; j < B.length; j++) {
                B[j] = B[j] ^ 1;
            }
            A[i] = B;
        }

        return A;
    }


    /**
     * 优化方案
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage1(int[][] A) {
        int len = A[0].length;
        for (int[] B : A){
            for (int i = 0; i < (len + 1) / 2; i++) {
                int temp = B[i] ^ 1;
                B[i] = B[len - 1 - i] ^ 1;
                B[len - 1 - i] = temp;
            }

        }
        return A;
    }


}
