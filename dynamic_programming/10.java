class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int j = 1; j <= n; j++) {
            if(p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                //* must show up in second position
                if(p.charAt(j - 1) == '*') {
                    //.....y
                    //....x*
                    //1.x* 视为 zero个x
                    //2.x* 视为 n个x，前提是x要与y相同，或者x是.
                    dp[i][j] = dp[i][j - 2] ||
                            ((p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) && dp[i - 1][j]);

                } else {
                    //....y
                    //....x
                    //x == y
                    //x == .
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));

                }
            }
        }
        return dp[m][n];
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int j = 1; j <= n; j++) {
            if(p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 2];
            }
        }

        for(int i = 1; i <= m; i++) {
            boolean[] next = new boolean[n + 1];
            for(int j = 1; j <= n; j++) {
                //* must show up in second position
                if(p.charAt(j - 1) == '*') {
                    //.....y
                    //....x*
                    //1.x* 视为 zero个x
                    //2.x* 视为 n个x，前提是x要与y相同，或者x是.
                    next[j] = next[j - 2] ||
                            ((p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) && dp[j]);

                } else {
                    //....y
                    //....x
                    //x == y
                    //x == .
                    next[j] = dp[j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));

                }
            }
            dp = next;
        }
        return dp[n];
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        if(n == 0) {
            return m == 0;
        }

        if(n > 1 && p.charAt(1) == '*') {
            return (m != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) && isMatch(s.substring(1), p)
                    || isMatch(s, p.substring(2));
        } else {
            return m != 0 && (s.charAt(0) ==  p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        if(n == 0) {
            return m == 0;
        }
        if(m == 0) {
            return n > 1 && p.charAt(1) == '*' && isMatch(s, p.substring(2));
        }

        if(n > 1 && p.charAt(1) == '*') {
            return ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) && isMatch(s.substring(1), p)
                    || isMatch(s, p.substring(2));
        } else {
            return (s.charAt(0) ==  p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }
    }
}
