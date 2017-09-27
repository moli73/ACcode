public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + matrix[i - 1][j - 1];
            }
        }
        int[][] res = new int[2][2];
        for(int u = 1; u <= m; u++) {
            for(int d = 1; d <= m; d++) {
                Map<Integer, Integer> map = new HashMap<>();
                int sum = 0;
                for(int j = 0; j <= n; j++) {
                    sum += preSum[d][j] - preSum[u - 1][j];
                    if(map.containsKey(sum)) {
                        res[0][0] = u - 1;
                        res[0][1] = map.get(sum);
                        res[1][0] = d - 1;
                        res[1][1] = j - 1;
                        return res;
                    } else {
                        map.put(sum, j);
                    }
                }
            }
        }
        return res;
    }
}
