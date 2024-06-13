package lab_pratice_ad2;
import java.util.*;

public class coin_exchange {
	public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 30;

        int minCoins = minCoins(coins, amount);
        System.out.println("Minimum number of coins required: " + minCoins);
    }
}
