public class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        List<Integer> res = new ArrayList<>();
        if(n == 0 || A[n - 1] == -1) {
            return res;
        }
        int[] dp = new int[n];
        int[] next = new int[n];
        next[n - 1] = -1;
        dp[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            next[i] = -1;
            dp[i] = Integer.MAX_VALUE;
            if(A[i] == -1) continue;
            for(int j = 1; j <= B && i + j < n; j++) {
                if(dp[i + j] != Integer.MAX_VALUE && dp[i + j] + A[i] < dp[i]) {
                    dp[i] = dp[i + j] + A[i];
                    next[i] = i + j;
                }
            }
        }

        if(dp[0] == Integer.MAX_VALUE) {
            return res;
        } else {
            res.add(1);
        }

        int nt = next[0];
        while(nt != -1) {
            res.add(nt + 1);
            nt = next[nt];
        }

        return res;
    }

}
