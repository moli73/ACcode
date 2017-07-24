public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        boolean[][] isPa = new boolean[n + 1][n + 1];
        dp[0] = -1;
        isPa[0][0] = true;
        for(int i = 1; i <= n; ++i){
            dp[i] = Integer.MAX_VALUE;
            for(int j = i - 1; j >= 0; --j){
                if((j + 1 == i) || (s.charAt(j) == s.charAt(i - 1) && (j + 2 == i || isPa[j + 2][i - 1]))){
                    isPa[j + 1][i] = true;
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}

//better condition arrange
//final best solution
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        boolean[][] isPa = new boolean[n + 1][n + 1];
        dp[0] = -1;
        isPa[0][0] = true;
        for(int i = 1; i <= n; ++i){
            dp[i] = i - 1;
            for(int j = i - 1; j >= 0; --j){
                if(s.charAt(j) == s.charAt(i - 1)){// x,xx,xxx are same
                    if(j + 3 >= i || isPa[j + 2][i - 1]){
                        isPa[j + 1][i] = true;
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n];
    }
}

//better variable name, belongs to interval DP
//two pass solution
public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        boolean[][] isValid = new boolean[n + 1][n + 1];

        for(int l = 1; l <= n; ++l){
            for(int i = 1; i <= n - l + 1; ++i){
                int j = i + l - 1;
                if(l == 1){
                    isValid[i][j] = true;
                } else {
                    isValid[i][j] = (s.charAt(i - 1) == s.charAt(j - 1) &&
                                        (l == 2 || isValid[i + 1][j - 1]));
                }
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = -1;

        for(int i = 1; i <= n; ++i){
            dp[i] = i - 1;
            for(int k = 0; k <= i - 1; ++k){
                if(isValid[k + 1][i]){
                    dp[i] = Math.min(dp[i], dp[k] + 1);
                }
            }
        }

        return dp[n];
    }
}
