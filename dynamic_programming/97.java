public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n1 + n2 != n3) return false;

        boolean[] dp = new boolean[n2 + 1];

        dp[0] = true;
        for(int j = 1; j <= n2; ++j){
            dp[j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[j - 1];
        }

        for(int i = 1; i <= n1; ++i){
            dp[0] = dp[0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
            for(int j = 1; j <= n2; ++j){
                dp[j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1]);
            }
        }
        return dp[n2];
    }
}
