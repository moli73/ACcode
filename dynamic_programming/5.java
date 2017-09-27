class Solution {
    public String longestPalindrome(String s) {
        String res = new String();
        int n = s.length();
        if(n == 0) {
            return res;
        }
        boolean[][] dp = new boolean[n][n];
        for(int l = 1; l <= n; l++) {
            for(int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                if(i == j || (s.charAt(i) == s.charAt(j) && (i + 1 == j || dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                    if(j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
