/**
 * @author: jixd
 * @date: 2020/12/12 10:54 上午
 */
public class Solution5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }


    public static String longestPalindrome(String s){
        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int k = 0;k < n;k++){
            for(int i = 0;i + k < n;i++){
                int j = i + k;
                if (k == 0){
                    dp[i][j] = true;
                }else if (k == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && k + 1 > res.length()){
                    res = s.substring(i,i + k + 1);
                }
            }
        }
        return res;


    }

}
