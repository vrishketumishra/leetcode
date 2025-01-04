import java.util.Scanner;

public class factors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER :");
        int n = in.nextInt();
        int count =1;
        while(count<=n) {
            if (n % count == 0) {
                System.out.println(count);
                //  count++;
            }
            count++;
        }

    }
}
