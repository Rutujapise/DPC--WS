public class DivisorCountTest {
    // Function to count divisors of N
    public static int countDivisors(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i == N / i) {
                    count++;  // perfect square divisor
                } else {
                    count += 2; // both i and N/i
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Given test cases
        int[] testCases = {18, 29, 100, 1, 997};

        for (int N : testCases) {
            int result = countDivisors(N);
            System.out.println("Input: N = " + N + " -> Output: " + result);
        }
    }
}
