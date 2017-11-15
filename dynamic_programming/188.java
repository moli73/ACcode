class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n <= 1) {
            return 0;
        }

        if(k >= n / 2) {
            int res = 0;
            for(int i = 0; i < n - 1; i++) {
                if(prices[i] < prices[i + 1]) {
                    res += prices[i + 1] - prices[i];
                }
            }
            return res;
        }


        int[][] dp = new int[k + 1][n];
        //dp[i][j]: represents the max profit up using at most i transactions until prices[j].


        //dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj])               { jj in range of [0, j-1] }
        //         = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))

        // dp[0, j] = 0; 0 transactions makes 0 profit
        // dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
        for(int i = 1; i <= k; i++) {
            int tempMax = dp[i - 1][0] - prices[0];
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tempMax);
                tempMax = Math.max(tempMax, dp[i - 1][j] - prices[j]);//计算tempMax，给后面使用
            }
        }

        return dp[k][n - 1];
    }
}
