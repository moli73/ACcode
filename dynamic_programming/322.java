public class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0 || amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; ++i){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < n; ++j){
                if(coins[j] <= i){
                    if(dp[i - coins[j]] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;

    }
}
//use amount + 1 as the bound
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0 || amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; ++i){
            dp[i] = amount + 1;
            for(int j = 0; j < n; ++j){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
