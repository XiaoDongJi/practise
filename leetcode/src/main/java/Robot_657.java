public class Robot_657 {


    public static boolean judgeCircle(String moves) {
        int indexR = 0;
        int indexL = 0;
        int indexU = 0;
        int indexD = 0;
        for (int i = 0; i < moves.length(); i++) {
            int cha = moves.charAt(i);
            if ('R' == cha){
                indexR++;
            }
            if ('L' == cha){
                indexL++;
            }
            if ('U' == cha){
                indexU++;
            }
            if ('D' == cha){
                indexD++;
            }
        }
       return indexR == indexL && indexU == indexD;

    }

    public static void main(String[] args) {
        judgeCircle("LL");
    }

}
