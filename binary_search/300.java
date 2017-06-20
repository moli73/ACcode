public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= n; ++i){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; ++i){
            int left = 0, right = n;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(dp[mid] <= nums[i]) left = mid;
                else right = mid;
            }
            if(dp[left] >= nums[i]) dp[left] = nums[i];
            else dp[right] = nums[i];
        }

        for(int i = n; i >= 0; --i){
            if(dp[i] != Integer.MAX_VALUE){
                return i;
            }
        }
        return 0;
    }
}
