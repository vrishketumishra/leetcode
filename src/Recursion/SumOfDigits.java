package Recursion;

public class SumOfDigits {
    static void main() {
        System.out.println(productofdigits(1234));
    }
    static public int sumofdigits(int n){
        if( n==0){
            return 0;
        }
        return (n%10)+ sumofdigits(n/10);
    }
    static public int productofdigits(int n){
        if( n<10){
            return n;
        }
        return (n%10)* productofdigits(n/10);
    }
}

