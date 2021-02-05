/**
 * @author: jixd
 * @date: 2021/1/30 10:32 上午
 */
public class Solution75 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        new Solution75().sortColors(arr);
    }


    public void sortColors(int[] nums) {
        int p1 = 0,p2 = nums.length - 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                swap(nums,p1,i);
                p1++;
            }else if(nums[i] == 2 && i < p2){
                swap(nums,p2 ,i);
                p2--;
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
