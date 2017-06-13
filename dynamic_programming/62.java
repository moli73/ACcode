public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int j = 0; j < n; ++j) dp[j] = 1;
        for(int i = 1; i < m; ++i){
            int temp = 0;
            for(int j = 0; j < n; ++j){
                dp[j] = dp[j] + temp;
                temp = dp[j];
            }
        }
        return dp[n - 1];
    }
}
