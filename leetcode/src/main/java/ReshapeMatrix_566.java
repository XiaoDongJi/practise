/**
 *
 */
public class ReshapeMatrix_566 {


    public static void main(String[] args) {

        int[][] nums = {{1,2},{3,4}};

        System.out.println(matrixReshape(nums,1,4));


    }

    /**
     *
     * 解题思路 边界条件判断    必须成绩相同才能继续转换
     * 然后把数组变成一维数组，第二次循环 依次存值
     *
     * time O(m*n)
     * space O(m*n)
     *
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if ((r * c) != (nums.length * nums[0].length)){
            return nums;
        }


        int index = 0;
        int[] temp = new int[nums.length * nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                temp[index++] = nums[i][j];
            }
        }
        index = 0;
        int[][] re = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                re[i][j] = temp[index++];
            }
        }

        return re;
    }


    /**
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape_1(int[][] nums, int r, int c) {
        if ((r * c) != (nums.length * nums[0].length)){
            return nums;
        }

        int rows =0,cols = 0;

        int[][] re = new int[r][c];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                re[rows][cols] = nums[i][j];
                cols++;
                if (cols == c){
                    cols = 0;
                    rows++;
                }
            }
        }

        return re;
    }


}
