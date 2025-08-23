class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";  // Edge case: empty array
        }

        // Take first string as prefix
        String prefix = strs[0];

        // Compare with each string
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1); // trim last char
                if (prefix.isEmpty()) {
                    return ""; // no common prefix
                }
            }
        }
        return prefix;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ✅ Test Cases
        String[][] testCases = {
            {"flower", "flow", "flight"},   // Common prefix: "fl"
            {"dog", "racecar", "car"},      // No prefix: ""
            {"apple", "ape", "april"},      // "ap"
            {""},                           // Single empty string: ""
            {"alone"},                      // Single string: "alone"
           
        };

        for (String[] test : testCases) {
            System.out.print("Input: ");
            if (test.length == 0) {
                System.out.println("[]");
            } else {
                System.out.print("[");
                for (int i = 0; i < test.length; i++) {
                    System.out.print("\"" + test[i] + "\"");
                    if (i < test.length - 1) System.out.print(", ");
                }
                System.out.println("]");
            }

            System.out.println("Output: \"" + sol.longestCommonPrefix(test) + "\"");
            System.out.println("-------------------");
        }
    }
}
