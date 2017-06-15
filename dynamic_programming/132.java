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
