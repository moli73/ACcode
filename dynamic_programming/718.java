class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m + 1][n + 1];

        int max = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(A[i - 1] == B[j - 1]) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;

                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


}


class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[] dp = new int[n + 1];

        int max = 0;

        for(int i = 1; i <= m; i++) {
            int[] next = new int[n + 1];
            for(int j = 1; j <= n; j++) {

                if(A[i - 1] == B[j - 1]) {

                   next[j] = dp[j - 1] + 1;

                }
                max = Math.max(max, next[j]);
            }
            dp = next;
        }
        return max;
    }
}
