public class ReverseWords_557 {


    public static  String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }

    public static void main(String[] args) {

        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));



    }

}
