import java.util.Arrays;

public class Methods {
    public static void main(String args[]) {
        String name= "Rishi Mishra";
        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());//original object didnt change it is creating a new object
        System.out.println(name.indexOf('M'));
        System.out.println("    Rishi  ".strip());
        System.out.println(Arrays.toString(name.split(" ")));

    }
}
