import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: jixd
 * @date: 2020/12/5 1:51 下午
 */
public class Offer79 {


    public static void main(String[] args) {
        int[] arr = new int[]{4,3,11};

        new Offer79().maxSlidingWindow(arr,3);

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++){
            while(!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        res[0] = queue.peekFirst();
        for(int i = k; i < nums.length; i++){
            if(queue.peekFirst() == nums[i - k]){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.removeLast();
            }
            queue.addLast(nums[i]);

            res[i - k + 1] = queue.peekFirst();
        }
        return res;
    }

}
