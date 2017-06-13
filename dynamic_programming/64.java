public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int j = 1; j < n; ++j) dp[j] = dp[j - 1] + grid[0][j];
        for(int i = 1; i < m; ++i){
            int temp = Integer.MAX_VALUE;
            for(int j = 0; j < n; ++j){
                dp[j] = Math.min(temp, dp[j]) + grid[i][j];
                temp = dp[j];
            }
        }
        return dp[n - 1];
    }
}
