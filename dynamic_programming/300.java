public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        int res = 1;
        dp[0] = 1;
        for(int i = 1; i < n; ++i){
            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
