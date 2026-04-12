import java.sql.Array;
import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a'+'b');
        System.out.println("a"+"b");
        System.out.println((char)('a'+3));
        System.out.println("rishi"+3);
        System.out.println("rishi" + new ArrayList<>());
        System.out.println("kinal" + new Integer(56) );
        System.out.println(new ArrayList<>() + ""+ new Integer(56));

    }
}
