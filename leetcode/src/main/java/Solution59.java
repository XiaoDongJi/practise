import java.util.ArrayList;
import java.util.List;

/**
 * @author: jixd
 * @date: 2020/12/28 10:39 上午
 */
public class Solution59 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = new Solution59().spiralOrder(matrix);
        System.out.println(integers.toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int l = 0,r = matrix[0].length - 1,t = 0,b = matrix.length - 1;
        int num = 1,tar = matrix[0].length * matrix.length;
        while(num < tar){
            for(int i = l;i <= r;i++) {
                ans.add(matrix[t][i]);
                num ++;
            }
            t++;
            for(int i = t;i<= b;i++){
                ans.add(matrix[i][r]);
                num++;
            }
            r--;
            for(int i = r;i >= l;i--){
                ans.add(matrix[b][i]);
                num++;
            }
            b--;
            for(int i = b;i>= t;i--){
                ans.add(matrix[i][l]);
                num++;
            }
            l++;
        }
        return ans;

    }

}
