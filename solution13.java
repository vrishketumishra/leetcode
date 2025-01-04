import java.util.HashMap;
import java.util.Map;

class Solution13 {
    public int romanToInt(String s) {
        // Define Roman numeral characters and their corresponding integer values
        String romanChars = "IVXLCDM";
        int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};

        // Create a map for quick lookup of Roman numeral values
        Map<Character, Integer> romanMap = new HashMap<>();
        for (int i = 0; i < romanValues.length; i++) {
            romanMap.put(romanChars.charAt(i), romanValues[i]);
        }

        int n = s.length();
        int result = romanMap.get(s.charAt(n - 1)); // Start with the value of the last character

        // Process the string from left to right, except the last character
        for (int i = 0; i < n - 1; i++) {
            int current = romanMap.get(s.charAt(i));
            int next = romanMap.get(s.charAt(i + 1));
            // If
