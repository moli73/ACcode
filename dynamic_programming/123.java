class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n <= 1) {
            return 0;
        }

        int[][] dp = new int[3][n];

        //dp[i][j] = max(dp[i][j - 1], dp[i - 1][jj] + prices[j] - prices[jj])  0 <= jj <= j - 1
        //         = max(dp[i][j - 1], max(dp[i - 1][jj] - prices[jj]) + prices[j])
        //dp[i][0] = 0;
        //dp[0][j] = 0;
        for(int i = 1; i <= 2; i++) {
            int tempMax = dp[i - 1][0] - prices[0];
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], tempMax + prices[j]);
                tempMax = Math.max(tempMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[2][n - 1];
    }
}
