package array;

import java.util.HashMap;
import java.util.Map;

public class ToeplitzMatrix_766 {



    /**
     *
     * 对角线值相同   可以利用对角线 角标详见相减数值相同，判断是否添加过来判断
     *
     * 时间复杂度 O(M∗N) 空间复杂度 O(M *N)
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer,Integer> store = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!store.containsKey(i - j)){
                    store.put(i - j,matrix[i][j]);
                }
                if (store.containsKey(i - j) && store.get(i-j) != matrix[i][j]){
                    return false;
                }

            }

        }

        return true;
    }

    /**
     *
     * 直接计算上下对角线 差值如果不相同 则返回false
     *
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (i > 0 && j > 0 && matrix[i-1][j-1] != matrix[i][j]){
                    return false;
                }

            }
        }

        return true;
    }

}
