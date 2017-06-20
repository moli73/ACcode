public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] left = new int[n], right = new int[n], height = new int[n];
        int res = 0;
        for(int j = 0; j < n; ++j){
            left[j] = 0; right[j] = n - 1; height[j] = 0;
        }
        for(int i = 0; i < m; ++i){
            int cur_left = 0;
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == '1'){
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    cur_left = j + 1; left[j] = 0;
                }
            }
            int cur_right = n - 1;
            for(int j = n - 1; j >= 0; --j){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(cur_right, right[j]);
                } else {
                    cur_right = j - 1; right[j] = n - 1;
                }
            }
            for(int j = 0; j < n; ++j){
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            for(int j = 0; j < n; ++j){
                res = Math.max(res, height[j] * (right[j] - left[j] + 1));
            }
        }
        return res;
    }
}
