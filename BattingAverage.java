import java.util.Scanner;

public class BattingAverage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter he number of inings : ");
        int  number = in.nextInt();
        int sum = 0;
        for (int count = 1; count <= number; count++) {
            System.out.print("enter the " + count + " ining score : ");
            int score = in.nextInt();
            sum =sum + score;
        }
        sum = sum/number;
        System.out.print("The batting Average of " + number + " inings is : " + sum);

    }
}
