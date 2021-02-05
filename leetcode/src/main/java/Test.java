import java.time.LocalDate;

/**
 * @author: jixd
 * @date: 2020/12/3 7:45 下午
 */
public class Test {

    public static void main(String[] args) {
        int a  = 1, b = 2;
        a ^= b;
        b ^= a;
        a ^=b;
        System.out.println(a );
        System.out.println(b);
    }

}
