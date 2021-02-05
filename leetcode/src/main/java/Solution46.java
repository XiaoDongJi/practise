import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: jixd
 * @date: 2021/1/24 12:01 下午
 */
public class Solution46 {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};

        Arrays.stream(arr).boxed().collect(Collectors.toList());

        System.out.println("lp1-wf".split("-")[0]);
        System.out.println("lp1-wf".substring("lp1-wf".indexOf("-") + 1));
       /* Solution46 solution46 = new Solution46();
        solution46.dfs(arr,0);
        System.out.println(solution46.ans);*/
    }



    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,0);
        return ans;
    }

    public void dfs(int[] nums,int index){
        if(nums.length == index){
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            swap(nums,i,index);
            dfs(nums,index + 1);
            swap(nums,i,index);
        }
    }


    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



}
