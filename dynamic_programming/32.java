public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), res = 0;
        int[] dp = new int[n];
        for(int i = 1; i < n; ++i){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else {
                    if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

//mock version
public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        //dp[i] shows the longest length of valid substring end with the i_th char in string s.
        int[] dp = new int[n + 1];
        int res = 0;
        char[] str = s.toCharArray();

        for(int i = 1; i <= n; i++) {
            if(str[i - 1] == ')') {
                if(i > 1 && str[i - 2] == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if(i > 1 && str[i - 2] == ')') {
                    int pre = dp[i - 1];
                    if(i - pre > 1 && str[i - pre - 2] == '(') {
                        dp[i] = dp[i - pre - 2] + pre + 2;
                    }
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
