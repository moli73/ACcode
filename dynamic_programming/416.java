space O(k)
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) {
            return true;
        }

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 == 1) {
            return false;
        }

        int k = sum / 2;
        int n = nums.length;

        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        for(int i = 1; i <= n; i++) {

            for(int j = k; j >= nums[i - 1]; j--) {

                dp[j] = dp[j] || dp[j - nums[i - 1]];

            }
        }

        return dp[k];
    }
}

space O(nk)
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) {
            return true;
        }

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 == 1) {
            return false;
        }

        int k = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][k + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++) {
            dp[i][0] = true; //dp[i][0]是一个初始化的状态
            for(int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if(nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][k];
    }
}
