class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int j = 1; j <= n; j++) {
            if(p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                //....x
                //....*
                //1.*为空
                //2.*x
                if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) && dp[i - 1][j - 1];
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
                dp[j] = dp[j - 1];
            }
        }

        for(int i = 1; i <= m; i++) {
            boolean[] next = new boolean[n + 1];
            for(int j = 1; j <= n; j++) {
                //....x
                //....*
                //1.*为空
                //2.*x
                if(p.charAt(j - 1) == '*') {
                    next[j] = dp[j] || next[j - 1];
                } else {
                    next[j] = (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) && dp[j - 1];
                }
            }
            dp = next;
        }

        return dp[n];
    }
}

//TLE
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        if(n == 0) {
            return m == 0;
        }

        if(p.charAt(0) == '*') {
            return m != 0 && isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        } else {
            return m != 0 && (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) && isMatch(s.substring(1), p.substring(1));
        }
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int match = 0;//record the last matched point of s
        int start = -1;//record the last * index
        while(i < s.length()) {
            //j < p.length(),放到loop里面，因为有可能i先到边界，j还未到边界，但是j剩下的都是*的情况
            if(j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                match = i;//记录下一个会被match到*的字符
                start = j;//记录*的位置
                j++;
            } else if(start != -1) {
                match++;//确认start被match到*中了，同时记录下一个会被match到*的字符
                i = match;
                j = start + 1;
            } else {
                return false;
            }
        }

        while(j < p.length()) {
            if(p.charAt(j) != '*') {
                return false;
            }
            j++;
        }

        return true;
    }
}
