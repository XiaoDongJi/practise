import java.util.ArrayList;
import java.util.List;

public class L57 {

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(5));

    }


    public static int[][] findContinuousSequence(int k){
        int left = 1,right = 2;
        List<int[]> result = new ArrayList<>();
        while (left < right){
            int sum = ((left + right) * (right - left + 1)) / 2;
            if (sum < k) right++;
            else if( sum > k) left++;
            else {
                int[] temp = new int[right - left + 1];
                for (int i = left;i <= right;i++){
                    temp[i-left] = i;
                }
                result.add(temp);
                left++;
            }
        }

        return result.toArray(new int[0][]);
    }

}
