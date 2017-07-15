public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] state = new int[m][n];

        for(int i = 0; i < m; i++){
            helper(matrix, state, i, 0, Integer.MIN_VALUE, 1);
        }
        for(int j = 0; j < n; j++){
            helper(matrix, state, 0, j, Integer.MIN_VALUE, 1);
        }
        for(int i = 0; i < m; i++){
            helper(matrix, state, i, n - 1, Integer.MIN_VALUE, 2);
        }
        for(int j = 0; j < n; j++){
            helper(matrix, state, m - 1, j, Integer.MIN_VALUE, 2);
        }

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(state[i][j] == 3) {
                    int[] pos = new int[2];
                    pos[0] = i;
                    pos[1] = j;
                    res.add(pos);
                }
            }
        }

        return res;
    }

    public void helper(int[][] matrix, int[][] state, int i, int j, int pre, int ocean) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }

        if(matrix[i][j] < pre) {
            return;
        }

        if(state[i][j] == 3 || state[i][j] == ocean) {
            return;
        }

        if(state[i][j] == 0) {
            state[i][j] = ocean;
        } else {
            state[i][j] = 3;
        }

        helper(matrix, state, i - 1, j, matrix[i][j], ocean);
        helper(matrix, state, i + 1, j, matrix[i][j], ocean);
        helper(matrix, state, i, j - 1, matrix[i][j], ocean);
        helper(matrix, state, i, j + 1, matrix[i][j], ocean);

    }
}
