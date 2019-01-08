package array;

/**
 *
 */
public class TransposeMatrix_867 {

    public int[][] transpose(int[][] A) {
        int len = A.length;
        int ne = A[0].length;
        int[][] B = new int[ne][len];
        for (int i = 0;i< len;i++){
            for (int j = 0; j < ne; j++) {
                B[j][i] = A[i][j];
            }

        }

        return B;
    }


}
