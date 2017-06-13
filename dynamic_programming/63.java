public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j] != 1){
                dp[j] = 1;
            } else break;
        }
        for(int i = 1; i < m; ++i){
            int temp = 0;
            for(int j = 0; j < n; ++j){
                if(obstacleGrid[i][j] != 1) dp[j] = dp[j] + temp;
                else dp[j] = 0;
                temp = dp[j];
            }
        }
        return dp[n - 1];
    }
}
