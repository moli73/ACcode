//先按组合方式分类，再判断，更清晰，有条理。
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int dp1 = 1;
        int dp2 = 1;
        for(int i = 2; i <= n; i++) {
            int temp = 0;
            //当前一位的情况
            if(s.charAt(i - 1) != '0') {
                temp += dp2;
            }
            //当前两位情况
            if((s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') && 10 * (s.charAt(i - 2) - '0') + (s.charAt(i - 1) - '0') <= 26) {
                temp += dp1;
            }
            dp1 = dp2;
            dp2 = temp;
        }
        return dp2;
    }
}
class Solution {
    public int numDecodings(String s) {
        //dp[i]: repreasent the first i chars in string ways
        //dp[i]: two : s[i] stays as one char or s[i - 1]s[i] combine as two chars
        // 1 ~ 9 one    0 can't
        // 10 ~ 26 is valid
        //dp[0] = 1;

        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;//initial

        for(int i = 1; i <= n; i++) {
            //one char
            if(s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            //two chars
            if(i > 1) {
                int num = 10 * (s.charAt(i - 2) - '0') + s.charAt(i - 1) - '0';
                if(num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

            if(dp[i] == 0) {
                return 0;
            }
        }

        return dp[n];
    }
}
//memorized search
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if(s.length() == 0) {
            return 0;
        }
        for(int i = 0; i < s.length(); i++) {
            dp[i] = -1;
        }
        return helper(s, s.length() - 1, dp);
    }

    public int helper(String s, int pos, int[] dp) {
        if(pos < 0) {
            return 1;
        }
        //memorized search
        if(dp[pos] != -1) {
            return dp[pos];
        }

        int res = 0;
        //one char
        if(s.charAt(pos) != '0') {
            res += helper(s, pos - 1, dp);
        }
        //two char
        if(pos > 0) {
            int temp = (s.charAt(pos - 1) - '0') * 10 + (s.charAt(pos) - '0');
            if(temp >= 10 && temp <= 26) {
                res += helper(s, pos - 2, dp);
            }
        }
        //update state
        dp[pos] = res;

        return res;
    }
}
