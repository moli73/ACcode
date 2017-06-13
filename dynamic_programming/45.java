//version 1: dynamic programming
public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for(int i = n - 2; i >= 0; --i){
            dp[i] = n;
            for(int j = Math.min(n - 1, i + nums[i]); j > i; --j){
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[0];
    }
}

//version 2: greedy
public class Solution {
    public int jump(int[] nums) {
        int curEnd = 0, farEnd = 0, step = 0, n = nums.length;
        if(n < 2) return 0;
        for(int i = 0; i < n; ++i){
            farEnd = Math.max(farEnd, i + nums[i]);
            if(i == curEnd){
                step++;
                curEnd = farEnd;
                if(curEnd >= n - 1) return step;
            }
        }
        return step;
    }
}
