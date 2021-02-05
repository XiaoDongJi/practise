import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2021/1/27 3:43 下午
 */
public class Solution238 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }



    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int p = 1,q = 1;
        for(int i = 0;i < nums.length;i++){
            res[i] = p;
            p *= nums[i];
        }
        for(int i = nums.length - 1; i > 0;i--){
            q *= nums[i];
            res[i - 1] *= q;
        }
        return res;
    }

}
