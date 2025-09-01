import java.util.Scanner;

public class DivisorCount {
    public static int countDivisors(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i == N / i) {
                    count++;  // Perfect square, count once
                } else {
                    count += 2; // Count both i and N/i
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(countDivisors(N));
        sc.close();
    }
}
