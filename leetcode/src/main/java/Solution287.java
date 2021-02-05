/**
 * @author: jixd
 * @date: 2021/1/28 3:29 下午
 */
public class Solution287 {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 5, 2, 3, 1, 6, 7};
        System.out.println(new Solution287().findDuplicate(arr));
    }


    public int findDuplicate(int[] nums) {
        int l = 1,r = nums.length - 1;
        while(l < r){
            int m = (l + r) >>> 1;
            int cnt = 0;
            for(int num : nums){
                if(num <= m){
                    cnt++;
                }
            }
            if(cnt > m){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }

}

