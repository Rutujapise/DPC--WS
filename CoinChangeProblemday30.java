import java.util.Arrays;

public class CoinChangeProblem {

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1; // acts as "infinity"
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0; // base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Input: coins = [1,2,5], amount = 11");
        System.out.println("Output: " + coinChange(coins1, amount1)); // Expected: 3

        // Test Case 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("\nInput: coins = [2], amount = 3");
        System.out.println("Output: " + coinChange(coins2, amount2)); // Expected: -1

        // Test Case 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("\nInput: coins = [1], amount = 0");
        System.out.println("Output: " + coinChange(coins3, amount3)); // Expected: 0

        // Extra Test Case 4
        int[] coins4 = {3, 7};
        int amount4 = 5;
        System.out.println("\nInput: coins = [3,7], amount = 5");
        System.out.println("Output: " + coinChange(coins4, amount4)); // Expected: -1

        // Extra Test Case 5
        int[] coins5 = {2, 5, 10};
        int amount5 = 27;
        System.out.println("\nInput: coins = [2,5,10], amount = 27");
        System.out.println("Output: " + coinChange(coins5, amount5)); // Expected: 4 (10+10+5+2)
    }
}
