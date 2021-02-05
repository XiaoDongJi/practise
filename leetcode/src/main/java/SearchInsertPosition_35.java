/**
 * <p>TODO</p>
 *
 * @author jixd
 * @Date Created in 2019年02月18日 15:58
 */
public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0 ;i< nums.length;i++){
            if (nums[i] == target){
                return i;
            }else if(nums[i] > target){
                return i;
            }
        }
        return nums.length;
    }

}
