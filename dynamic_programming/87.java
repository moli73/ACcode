public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        int n = s1.length();
        boolean[][][] dp = new boolean[n + 1][n + 1][n + 1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                dp[1][i][j] = (s1.charAt(i - 1) == s2.charAt(j - 1));
            }
        }

        for(int len = 2; len <= n; ++len){
            for(int i = 1; i <= n -len + 1; ++i){
                for(int j = 1; j <= n - len + 1; ++j){
                    for(int l = 1; l <= len; ++l){
                        dp[len][i][j] = dp[len][i][j] ||
                        (dp[l][i][j] && dp[len - l][i + l][j + l]) ||
                        (dp[l][i][j + len -l] && dp[len - l][i + l][j]);
                    }
                }
            }
        }

        return dp[n][1][1];
    }
}

//recursion solution
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int len = s1.length();
        if(len == 0 || s1.equals(s2)) return true;

        int[] count = new int[256];
        for(int i = 0; i < len; ++i){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }
        for(int i = 0; i < len; ++i){
            if(count[s1.charAt(i)] != 0){
                return false;
            }
        }

        for(int i = 1; i < len; ++i){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if(isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }
}
