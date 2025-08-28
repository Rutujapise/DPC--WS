import java.util.*;

public class CountSubstringsKDistinct {

    // Function to count substrings with at most K distinct characters
    private static int atMostKDistinct(String s, int k) {
        int n = s.length();
        int left = 0, count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink window until we have at most k distinct characters
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            // All substrings ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }

    // Function to count substrings with exactly K distinct characters
    public static int countExactlyKDistinct(String s, int k) {
        if (k == 0) return 0;
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    // Run test cases
    public static void main(String[] args) {
        runTest("pqpqs", 2, 7);
        runTest("aabacbebe", 3, 10);
        runTest("a", 1, 1);
        runTest("abc", 3, 1);
        runTest("abc", 2, 2);

    }

    // Helper method for testing
    private static void runTest(String s, int k, int expected) {
        int result = countExactlyKDistinct(s, k);
        System.out.println("Input: s = \"" + s + "\", k = " + k);
        System.out.println("Output: " + result );
        System.out.println(result == expected ? "✅ Passed\n" : "❌ Failed\n");
    }
}

