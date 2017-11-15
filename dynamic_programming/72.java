class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        for(int j = 1; j <= n; j++) {
            dp[j] = j;
        }

        for(int i = 1; i <= m; i++) {
            int[] next = new int[n + 1];
            next[0] = i;//key point to optimize the space

            for(int j = 1; j <= n; j++) {

                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    next[j] = dp[j - 1];

                } else {

                    next[j] = Math.min(Math.min(dp[j], next[j - 1]), dp[j - 1]) + 1;

                }
            }
            dp = next;
        }

        return dp[n];
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {

                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;

                }

            }
        }

        return dp[m][n];
    }
}

/*
...c

...d


*/
