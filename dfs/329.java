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
