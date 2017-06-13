//version 1: dynamic programming
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i = 0; i < n - 1; ++i){
            if(dp[i] == false) return false;
            for(int j = Math.min(i + nums[i], n - 1); j > i; --j){
                if(dp[j] == true) break;
                dp[j] = dp[i];
            }
        }
        return dp[n - 1];
    }
}

//version 2: greedy
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 0) return true;
        int right = nums[0];
        for(int i = 1; i < n; ++i){
            if(right >= i){
                right = Math.max(right, i + nums[i]);
            }
        }
        return right >= n - 1;
    }
}
