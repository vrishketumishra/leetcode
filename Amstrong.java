import java.util.Scanner;

public class Amstrong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(" Enter the number : ");
        int n = in.nextInt();
        int power =1;
        int amstrong =0;
        int count = 0;
        int temp =n;
       int  check =n;
        while(n>0) {
            int rem = n % 10;
            count++;
            n /= 10;
        }
        while(temp>0)
        {
            int sum = temp % 10;
            for (int i = 1; i <=count ; i++) {
                power = power * sum;
            }
            amstrong += power;
            power =1;
            temp/=10;
        }
        if (check == amstrong){
            System.out.println("it is a amstrong no. ");
        }
        else{
            System.out.println("it is not a amstrong no. ");
        }
    }
}
