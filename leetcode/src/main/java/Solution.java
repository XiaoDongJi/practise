import java.util.*;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("xiaobai:2", "xiaobai:3", "xiaoqiang:5");
        System.out.println(doWork(strings));
    }

    public static String doWork(List<String> nameScores){
        Map<String,Integer> map = new LinkedHashMap<>();
        for (String str : nameScores){
            String[] split = str.split(":");
            if (map.containsKey(split[0])){
                map.put(split[0],map.get(split[0]) + Integer.parseInt(split[1]));
            }else{
                map.put(split[0], Integer.parseInt(split[1]));
            }
        }
        //int [] scores = new int[map.size()];
        Collection<Integer> values = map.values();
        Integer max = values.stream().max(Integer::compareTo).get();
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            if (entry.getValue().intValue() == max.intValue()){
                return entry.getKey();
            }
        }
        return null;
    }

}
