import java.util.*;

public class PrimeFactorizationTest {
    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        // Factor out 2s
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Factor out odd numbers from 3 to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If n is still > 2, it's prime
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }

    public static void main(String[] args) {
        int[] testCases = {30, 49, 19, 64, 123456};

        for (int n : testCases) {
            System.out.println("Input: " + n);
            System.out.println("Output: " + primeFactors(n));
            System.out.println();
        }
    }
}
