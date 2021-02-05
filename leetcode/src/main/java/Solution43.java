import java.util.Arrays;

/**
 * @author: jixd
 * @date: 2020/12/26 3:15 下午
 */
public class Solution43 {

    public static void main(String[] args) {
        System.out.println(new Solution43().multiply("123","456"));
    }


    public String multiply(String num1, String num2) {
        int m = num1.length(),n = num2.length();
        int[] arr = new int[m + n];
        Arrays.fill(arr,0);
        for(int i = m - 1;i >=0;i--){
            for(int j = n - 1;j >= 0;j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j,p2 = i + j + 1;
                int sum = mul + arr[p2];
                arr[p2] = sum % 10;
                arr[p1] += sum / 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < arr.length;i++){
            if(sb.toString().equals("") && arr[i] == 0){
                continue;
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }

}
