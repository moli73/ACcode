public class Solution {
    public int numDistinct(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int[] dp = new int[n2 + 1];
        dp[0] = 1;
        for(int i = 1; i <= n1; ++i){
            int pre = dp[0];
            for(int j = 1; j <= n2; ++j){
                int temp = dp[j];
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[j] = pre + dp[j];
                }
                pre = temp;
            }
        }
        return dp[n2];
    }
}
