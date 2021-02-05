public class ReverseString_344 {
    public void reverseString(char[] s) {
            int start = 0;
            int end = s.length - 1;
            for (int i = 0; i < s.length;i++){
                if (end > start){
                    char tem = s[end];
                    s[end] = s[start];
                    s[start] = tem;

                    start++;
                    end--;
                }else{
                    break;
                }
            }
    }

}
