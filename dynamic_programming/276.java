public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        int[] dp = new int[n + 3];
        dp[0] = 1;
        dp[1] = k;
        dp[2] = k * k;
        for(int i = 3; i <= n; ++i){
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }
        return dp[n];
    }
}
//O(1) space
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n == 1) return k;
        int dp1 = k, dp2 = k * k;
        for(int i = 3; i <= n; ++i){
            int temp = dp2;
            dp2 = (dp2 + dp1) * (k - 1);
            dp1 = temp;
        }
        return dp2;
    }
}
