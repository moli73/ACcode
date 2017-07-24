public class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int l = 1; l <= n; ++l){
            for(int i = 0; i < n - l + 1; ++i){
                int j = i + l - 1;
                if(i == j) dp[i][j] = 1;
                else if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}
