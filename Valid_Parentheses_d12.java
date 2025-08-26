import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        // Edge case: odd length string can’t be valid
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If stack is empty or mismatch occurs
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // Stack should be empty if valid
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValid("()"));       // true
        System.out.println(isValid("([)]"));     // false
        System.out.println(isValid("[{()}]"));   // true
        System.out.println(isValid(""));         // true
        System.out.println(isValid("{[}"));      // false
    }
}
