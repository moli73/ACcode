public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if(m == 0) return 1;
        int n = dungeon[0].length;
        if(n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int j = n - 1; j >= 0; --j){
            dp[j] = dp[j + 1] - dungeon[m - 1][j];
            if(dp[j] <= 0) dp[j] = 1;
        }

        for(int i = m - 2; i >= 0; --i){
            int temp = Integer.MAX_VALUE;
            for(int j = n - 1; j >= 0; --j){
                dp[j] = Math.min(dp[j], temp) - dungeon[i][j];
                if(dp[j] <= 0) dp[j] = 1;
                temp = dp[j];
            }
        }

        return dp[0];
    }
}
