public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int j = 1; j <= n; ++j){
            dp[j] = j;
            for(int i = 2; i * i <= j; ++i){
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
