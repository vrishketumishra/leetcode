import java.util.Scanner;

public class calculator
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //take input till the user does not press 'x' or 'X'
        int ans=0;
        while (true){
            //take the operator from user
            System.out.print("Enter the operator : ");
            char ch = in.next().trim().charAt(0);
            if (ch =='+' || ch =='-' || ch =='*' || ch =='/' || ch =='%')
            {
                System.out.print("Enter the numbers : ");
                int num1= in.nextInt();
                int num2 = in.nextInt();
                if(ch =='+'){
                    ans=num1 + num2;
                }
                if(ch =='-'){
                    ans=num1 - num2;
                }
                if(ch =='*'){
                    ans=num1 * num2;
                }
                if(ch =='/'){
                    if(ch!=0){
                    ans=num1 / num2;}
                }
                if(ch =='%'){
                    ans=num1 % num2;
                } }

                else if (ch =='x' || ch =='X') {
                    break;
                } else {
                    System.out.println("invalid operator !!!");
                }
            System.out.println(ans);



        }
    }
}
