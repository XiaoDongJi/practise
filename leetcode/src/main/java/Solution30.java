import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: jixd
 * @date: 2020/12/2 4:22 下午
 */
public class Solution30 {

    public static void main(String[] args) {

        System.out.println(isValid("(){}}{"));

    }

    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;

    }

}
