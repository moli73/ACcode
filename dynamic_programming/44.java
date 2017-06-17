public class Solution {
    public boolean isMatch(String s, String p) {
        int n1 = s.length(), n2 = p.length();
        boolean[] dp = new boolean[n2 + 1];

        dp[0] = true;
        for(int j = 1; j <= n2; ++j){
            if(p.charAt(j - 1) == '*'){
                dp[j] = dp[j - 1];
            }
        }

        for(int i = 1; i <= n1; ++i){
            boolean pre = dp[0];
            dp[0] = false;
            for(int j = 1; j <= n2; ++j){
                boolean temp = dp[j];
                if(p.charAt(j - 1) == '*'){
                    dp[j] = dp[j] || dp[j - 1];
                } else {
                    dp[j] = pre && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1));
                }
                pre = temp;
            }
        }

        return dp[n2];
    }
}
