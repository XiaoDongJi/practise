package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: jixd
 * @date: 2020/11/2 8:57 上午
 */
public class Solution406 {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        int[][] ints = reconstructQueue(arr);

        System.out.println(ints);
    }

    public static int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for(int[] p : people){
            System.out.println(p[1]);
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }


}
