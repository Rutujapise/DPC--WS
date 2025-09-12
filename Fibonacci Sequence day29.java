import java.math.BigInteger;

public class FibonacciTestCases {

    public static BigInteger fibonacci(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger prev2 = BigInteger.ZERO;
        BigInteger prev1 = BigInteger.ONE;
        BigInteger curr = BigInteger.ZERO;

        for (int i = 2; i <= n; i++) {
            curr = prev1.add(prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {5, 10, 0, 1000};

        for (int n : testCases) {
            System.out.println("Input: " + n);
            System.out.println("Output: " + fibonacci(n));
            System.out.println("----------------------------");
        }
    }
}
