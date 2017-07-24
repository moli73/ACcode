public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) {
            return 0;
        }

        int sumAll = 0;
        for(int num : nums) {
            sumAll += num;
        }

        if(S < -sumAll || S > sumAll) {
            return 0;
        }

        if((sumAll - S) % 2 == 1) {
            return 0;
        }

        int target = (sumAll - S) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;//initialization is tricky
        for(int i = 0; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
