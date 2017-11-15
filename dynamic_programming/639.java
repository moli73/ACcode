class Solution {
    public int numDecodings(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        int mode = (int)Math.pow(10, 9) + 7;

        int n = s.length();
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            //one char combination
            if(s.charAt(i - 1) == '*') {//current is *
                dp[i] += dp[i - 1] * 9;
            } else if (s.charAt(i - 1) != '0') {//curren is 1 - 9
                dp[i] += dp[i - 1];
            }

            if(i < 2) continue;
            //two char combination
            if(s.charAt(i - 2) == '*') {// former is *
                if(s.charAt(i - 1) == '*') {// current is *
                    dp[i] += dp[i - 2] * (9 + 6);
                } else if(s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6') {// *0 - *6, * could be 1 or 2
                    dp[i] += dp[i - 2] * 2;
                } else {// *7 - *9, * only could be 1
                    dp[i] += dp[i - 2];
                }
            } else {// former is 0 - 9
                if(s.charAt(i - 1) == '*') {//current is *
                    if(s.charAt(i - 2) == '1') {//former is 1, 1* could be 11 - 19
                        dp[i] += dp[i - 2] * 9;
                    } else if(s.charAt(i - 2) == '2') {//former is 2, 2* could be 21 - 26
                        dp[i] += dp[i - 2] * 6;
                    }
                } else {//current is 0 - 9
                    int temp = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                    if(temp >= 10 && temp <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }
            }

            if(dp[i] == 0) {
                return 0;
            }
            dp[i] %= mode;//tricky的地方

        }

        return (int)dp[n];
    }
}
