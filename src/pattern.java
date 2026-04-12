public class pattern {
    public static void main(String args[]) {
        pattern2(5);

    }
    public static void pattern1(int n) {

        for (int row = 0; row <= n; row++) {
            for (int col = 0; col < row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n) {

        for (int row = 0; row <= 2*n-1; row++) {
            for (int col = 0; col < n - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
