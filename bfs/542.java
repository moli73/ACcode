// Time complexity: O(r \cdot c)O(r⋅c).
// Since, the new cells are added to the queue only if their current distance is greater than the calculated distance,
// cells are not likely to be added multiple times.
public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length, n = matrix[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[] delta = {-1, 0, 1, 0, -1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    q.offer(new int[] {i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int k = 0; k < 4; k++) {
                int i = cur[0] + delta[k], j = cur[1] + delta[k + 1];
                if(i < 0 || i >= m || j < 0 || j >= n) continue;

                if(matrix[i][j] > matrix[cur[0]][cur[1]] + 1) {
                    matrix[i][j] = matrix[cur[0]][cur[1]] + 1;
                    q.offer(new int[] {i, j});
                }
            }
        }

        return matrix;
    }
}
