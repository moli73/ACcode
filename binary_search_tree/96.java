public class Solution {
    public int numTrees(int n) {
        if(n < 3) return n;
        int res = 0;
        for(int i = 2; i <= n - 1; ++i) res += numTrees(i - 1) * numTrees(n - i);
        res += 2 * numTrees(n - 1);
        return res;
    }
}

//iteration solution
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j )
                dp[i] += dp[j - 1] * dp[i - j];
        }
        return dp[n];
    }
}
