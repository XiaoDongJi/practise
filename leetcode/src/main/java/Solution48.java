import java.util.HashMap;
import java.util.Map;

/**
 * @author: jixd
 * @date: 2020/12/8 5:18 下午
 */
public class Solution48 {
    public static void main(String[] args) {
        System.out.println(new Solution48().lengthOfLongestSubstring("abcabcdbb"));
    }


    public int lengthOfLongestSubstring(String s){
        int res = 0,tmp = 0;
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int j = 0;j < chars.length;j++){
            Integer i = map.getOrDefault(chars[j], -1);
            tmp = tmp < j - i ? tmp + 1: j - i;
            res = Math.max(res,tmp);
            map.put(chars[j],j);
        }
        return res;
    }


}
