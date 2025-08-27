class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, maxLen = 1;

        // helper function: expand from center
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // odd length
            int len2 = expandFromCenter(s, i, i + 1); // even length
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }
}
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestPalindrome("babad")); // "bab" or "aba"
        System.out.println(sol.longestPalindrome("cbbd"));  // "bb"
        System.out.println(sol.longestPalindrome("a"));     // "a"
        System.out.println(sol.longestPalindrome("aaaa"));  // "aaaa"
        System.out.println(sol.longestPalindrome("abc"));   // "a"
    }
}

