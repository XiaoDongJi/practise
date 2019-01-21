package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsofLargeGroups_830 {

    /**
     *
     * 1.找一个值记录角标值
     * 2.
     *
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, N = S.length();
        for (int j = 0; j < N; j++) {
            if (j == N - 1 || S.charAt(j) != S.charAt(j + 1)){
                if (j - i + 1 >= 3){
                    ans.add(Arrays.asList(i,j+1));
                }
                i = j + 1;
            }
        }
        return ans;
    }


}
