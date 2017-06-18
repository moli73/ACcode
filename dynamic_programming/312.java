//we can find that for any balloons left the maxCoins does not depends on the balloons already bursted.
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coins = new int[n + 2];
        coins[0] = 1;
        coins[n + 1] = 1;
        for(int i = 1; i <= n; ++i) coins[i] = nums[i - 1];

        int[][] dp = new int[n + 2][n + 2];
        for(int l = 1; l <= n; ++l){
            for(int i = 1; i <= n - l + 1; ++i){
                int j = i + l - 1;
                for(int k = i; k <= j; ++k){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + coins[i - 1] * coins[j + 1] * coins[k]);
                }
            }
        }
        return dp[1][n];
    }
}
