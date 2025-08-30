public class LCMTestCases {

    // Function to calculate GCD using Euclidean algorithm
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM using formula
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;  // divide first to avoid overflow
    }

    public static void main(String[] args) {
        // Test cases
        long[][] testCases = {
            {4, 6},
            {5, 10},
            {7, 3},
            {1, 987654321},
            {123456, 789012}
        };

        // Run all test cases
        for (long[] test : testCases) {
            long N = test[0];
            long M = test[1];
            long result = lcm(N, M);
            System.out.println("Input: N = " + N + ", M = " + M);
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}
