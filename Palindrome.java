import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = in.nextInt();
        int rev = 0;
        int orig = n;
        while(n>0){
            int rem = n%10;
            rev = (rev*10)+rem;
            n = n/10;
        }
        if (orig==rev){
            System.out.println("The give number " + orig + " is a palindrome");
        }
        else{
            System.out.println("The given number " + orig + " is not a palindrome");
        }
    }
}
