import java.util.*;

public class PostfixEvaluator {
    
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand
                int result = applyOperation(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token)); // push operand
            }
        }

        return stack.pop(); // final result
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") 
            || token.equals("*") || token.equals("/");
    }

    private static int applyOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // integer division (Java truncates toward zero)
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    // Test the implementation
    public static void main(String[] args) {
        System.out.println(evaluatePostfix("2 1 + 3 *")); // 9
        System.out.println(evaluatePostfix("5 6 +"));     // 11
        System.out.println(evaluatePostfix("-5 6 -"));    // -11
        System.out.println(evaluatePostfix("15 7 1 1 + - / 3 * 2 1 1 + + -")); // 5
        System.out.println(evaluatePostfix("5"));         // 5
    }
}
