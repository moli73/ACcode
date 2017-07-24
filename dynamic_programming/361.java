public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp1 = new int[m + 2][n + 2],//up
                dp2 = new int[m + 2][n + 2], //down
                dp3 = new int[m + 2][n + 2], //left
                dp4 = new int[m + 2][n + 2];//right
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(grid[i - 1][j - 1] == 'E'){
                    dp1[i][j] = dp1[i - 1][j] + 1;
                    dp3[i][j] = dp3[i][j - 1] + 1;
                } else if(grid[i - 1][j - 1] == '0'){
                    dp1[i][j] = dp1[i - 1][j];
                    dp3[i][j] = dp3[i][j - 1];
                }
            }
        }
        for(int i = m; i >= 1; --i){
            for(int j = n; j >= 1; --j){
                if(grid[i - 1][j - 1] == 'E'){
                    dp2[i][j] = dp2[i + 1][j] + 1;
                    dp4[i][j] = dp4[i][j + 1] + 1;
                } else if(grid[i - 1][j - 1] == '0'){
                    dp2[i][j] = dp2[i + 1][j];
                    dp4[i][j] = dp4[i][j + 1];
                }
            }
        }
        int res = 0;
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(grid[i - 1][j - 1] == '0'){
                    res = Math.max(res, dp1[i][j] + dp2[i][j] + dp3[i][j] + dp4[i][j]);
                }
            }
        }
        return res;
    }
}

//version 2:
StefanPochmann
Reputation:  16,238
Walk through the matrix. At the start of each non-wall-streak (row-wise or column-wise), count the number of hits in that streak and remember it. O(mn) time, O(n) space.

int maxKilledEnemies(vector<vector<char>>& grid) {
   int m = grid.size(), n = m ? grid[0].size() : 0;
   int result = 0, rowhits, colhits[n];
   for (int i=0; i<m; i++) {
       for (int j=0; j<n; j++) {
           if (!j || grid[i][j-1] == 'W') {
               rowhits = 0;
               for (int k=j; k<n && grid[i][k] != 'W'; k++)
                   rowhits += grid[i][k] == 'E';
           }
           if (!i || grid[i-1][j] == 'W') {
               colhits[j] = 0;
               for (int k=i; k<m && grid[k][j] != 'W'; k++)
                   colhits[j] += grid[k][j] == 'E';
           }
           if (grid[i][j] == '0')
               result = max(result, rowhits + colhits[j]);
       }
   }
   return result;
}
