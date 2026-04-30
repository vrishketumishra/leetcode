package Recursion;

public class Factorial {
    static void main() {
        System.out.println(fact(5));
    }
    static int fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }
}
