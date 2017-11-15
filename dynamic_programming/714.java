class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null) {
            return 0;
        }
        int n = prices.length;
        int[] hold = new int[n];
        int[] sold = new int[n];
        if(n == 0 || n == 1) {
            return 0;
        }

        hold[0] = -prices[0];
        sold[0] = 0;

        for(int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(hold[i - 1] - fee + prices[i], sold[i - 1]);
        }

        return sold[n - 1];
    }
}
