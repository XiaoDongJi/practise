package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 *Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * @author jixd
 * @Date Created in 2019年01月16日 19:45
 */
public class PascalTriangle_118 {

    /**
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0){
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
            }
            res.add(row);
        }
        return res;

    }

}
