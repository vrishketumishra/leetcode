package Recursion;

public class ReverseAno {
    static int sum=0;
    static void rev(int n){
        if(n==0){
            return ;
        }
        int rem=n%10;
        sum=sum*10 +rem;
         rev(n/10);
    }
    static int Rev2(int n){
    //sometimes you might need sime additional variables in the argument
    //in that case, make another function
        int digits=(int)(Math.log10(n))+1;
        return helper(n, digits);
    }
    private static int helper(int n,int digits){
        if(n%10==n){
            return n;
        }
        int rem=n%10;
        return (int) (rem * Math.pow(10,digits-1) + helper(n/10,digits-1));
    }
    static void main() {

        System.out.println(Rev2(1234));
    }

}
