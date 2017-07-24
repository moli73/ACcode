//version 1: O(n^3)
public class Solution {
    public int numTrees(int n) {
        if(n == 0) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1; i <= n; ++i) dp[i][i] = 1;
        for(int l = 2; l <= n; ++l){
            for(int i = 1; i <= n - l + 1; ++i){
                int j = i + l - 1;
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1];
                for(int k = i + 1; k < j; ++k){
                    dp[i][j] += dp[i][k - 1] * dp[k + 1][j];
                }
            }
        }
        return dp[1][n];
    }
}

//version 2: O(n^2)
public class Solution {
    public int numTrees(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int l = 2; l <= n; ++l){
            for(int k = 0; k <= l - 1; ++k){
                dp[l] += dp[k] * dp[l - k - 1];
            }
        }
        return dp[n];
    }
}
