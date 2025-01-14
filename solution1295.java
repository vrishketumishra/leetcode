public class solution1295 {
    public static void main(String[] args) {
        int[] nums = {12, 234, 4, 3, 23, 2};
        System.out.println(findNumbers(nums));
    }

    static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) { // Fixed incorrect syntax
            if (isEven(num)) { // Corrected method call to `isEven`
                count++;
            }
        }
        return count;
    }

    static boolean isEven(int num) {
        int numberOfDigits = digits(num);
        return numberOfDigits % 2 == 0; // Simplified the condition
    }

    static int digits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
