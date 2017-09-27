class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }
        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];
        dp0[1] = 0;
        dp1[1] = -prices[0];
        for(int i = 2; i <= n; i++) {
            dp0[i] = Math.max(dp0[i - 1], dp1[i - 1] + prices[i - 1]);
            dp1[i] = Math.max(dp1[i - 1], dp0[i - 2] - prices[i - 1]);
        }
        return dp0[n];
    }
}
