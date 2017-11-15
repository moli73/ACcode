public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        //dp[i][j] for LCS of first i chars in A and first j chars in B
        //if i == j: dp[i][j] = dp[i - 1][j - 1] + 1
        //else j != j: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        //dp[0][0] = 0
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

public class Solution {
    /*
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        //dp[i][j] for LCS of first i chars in A and first j chars in B
        //if i == j: dp[i][j] = dp[i - 1][j - 1] + 1
        //else j != j: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        //dp[0][0] = 0
        int m = A.length();
        int n = B.length();
        int[] dp = new int[n + 1];
        for(int i = 1; i <= m; i++) {
            int[] next = new int[n + 1];
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    next[j] = dp[j - 1] + 1;
                } else {
                    next[j] = Math.max(dp[j], next[j - 1]);
                }
            }
            dp = next;
        }
        return dp[n];
    }
}
