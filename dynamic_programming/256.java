public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] dp = new int[3];
        for(int i = 1; i <= n; ++i){
            int[] temp = dp.clone();
            dp[0] = Math.min(temp[1] , temp[2]) + costs[i - 1][0];
            dp[1] = Math.min(temp[0] , temp[2]) + costs[i - 1][1];
            dp[2] = Math.min(temp[0] , temp[1]) + costs[i - 1][2];
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
