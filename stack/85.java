public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[] heights = new int[n + 2];

        for(int i = 0; i < m; i++) {
            Stack<Integer> s = new Stack<>();
            s.push(0);
            for(int j = 1; j <= n + 1; j++) {
                if(j != n + 1) {
                    heights[j] = matrix[i][j - 1] == '1' ? heights[j] + 1 : 0;
                }
                while(heights[s.peek()] > heights[j]) {
                    int cur = s.pop();
                    res = Math.max(res, (j - s.peek() - 1) * heights[cur]);
                }
                s.push(j);
            }
        }
        return res;
    }
}
