package Recursion;

public class palindrome {
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
    static boolean Palindrome(int n) {
        if (n == Rev2(n)) {
            return true;
        }
        else{
            return false;
        }
    }
    static void main() {

        System.out.println(Palindrome(121));
    }

}
