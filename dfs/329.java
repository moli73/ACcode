//DFS + memorization
class Solution {
    private int max = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] len = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(len[i][j] == 0) {
                    helper(i, j, len, matrix);
                }
            }
        }
        return max;
    }

    private int helper(int x, int y, int[][] len, int[][] matrix) {
        if(len[x][y] != 0) {
            return len[x][y];
        } else {
            int[] d = {-1, 0, 1, 0, -1};
            len[x][y] = 1;
            for(int t = 0; t < 4; t++) {
                int i = x + d[t];
                int j = y + d[t + 1];
                if(i < 0 || i >= len.length || j < 0 || j >= len[0].length) continue;
                if(matrix[i][j] > matrix[x][y]) {
                    len[x][y] = Math.max(len[x][y], helper(i, j, len, matrix) + 1);
                }
            }
            max = Math.max(max, len[x][y]);
            return len[x][y];
        }
    }
}

/**
[[7,7,5],
 [2,4,6],
 [8,2,0]]

1
memorized search
key,二维脚标转化成一维 m * n (i, j)  n*i + j



*/
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {//invalid input
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;


        int[][] len = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, helper(matrix, len, i, j, Integer.MIN_VALUE));
            }
        }
        return max;
    }

    private int helper(int[][] matrix, int[][] len, int i, int j, int last) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= last) {
            return 0;//不要visited，因为increasing的条件，包含了visited
        }

        if(len[i][j] != 0) {
            return len[i][j];
        }

        int[] d = {1,0,-1,0,1};
        int res = 1;
        for(int k = 0; k < 4; k++) {
            res = Math.max(res, helper(matrix, len, i + d[k], j + d[k + 1], matrix[i][j]) + 1);
        }

        len[i][j] = res;
        return res;
    }
}

//version 1: void dfs
public class Solution {
    private int res = 0;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] count = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(matrix, count, i, j, Integer.MIN_VALUE, 0);
            }
        }

        return res;
    }

    public void helper(int[][] matrix, int[][] count, int i, int j, int pre, int level) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || pre >= matrix[i][j]) {
            return;
        }

        if(level + 1 > count[i][j]) {
            count[i][j] = level + 1;
        } else {
            return;
        }

        res = Math.max(res, count[i][j]);

        helper(matrix, count, i - 1, j, matrix[i][j], count[i][j]);
        helper(matrix, count, i + 1, j, matrix[i][j], count[i][j]);
        helper(matrix, count, i, j - 1, matrix[i][j], count[i][j]);
        helper(matrix, count, i, j + 1, matrix[i][j], count[i][j]);
    }
}

//vresion 2: divide and conquer, better time complexity
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] count = new int[m][n];

        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, helper(matrix, count, i, j, Integer.MIN_VALUE));
            }
        }

        return res;
    }

    public int helper(int[][] matrix, int[][] count, int i, int j, int pre) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || pre >= matrix[i][j]) {
            return 0;
        }
        if(count[i][j] > 0) {
            return count[i][j];
        }

        int up = helper(matrix, count, i - 1, j, matrix[i][j]);
        int down = helper(matrix, count, i + 1, j, matrix[i][j]);
        int left = helper(matrix, count, i, j - 1, matrix[i][j]);
        int right = helper(matrix, count, i, j + 1, matrix[i][j]);

        count[i][j] = Math.max(up, Math.max(down, Math.max(left, right))) + 1;//important to update

        return count[i][j];
    }
}
