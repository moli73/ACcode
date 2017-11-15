class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(S < -sum || S > sum) {
            return 0;
        }

        if((sum - S) % 2 == 1) {
            return 0;
        }

        int k = (sum - S) / 2;
        int n = nums.length;

        int[] dp = new int[k + 1];
        dp[0] = 1;//前0个数中，找sum为0的subset的方式有一种方式

        for(int i = 1; i <= n; i++) {
            for(int j = k; j >= nums[i - 1]; j--) {

                dp[j] += dp[j - nums[i - 1]];

            }
        }
        return dp[k];
    }
}


class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(S < -sum || S > sum) {
            return 0;
        }

        if((sum - S) % 2 == 1) {
            return 0;
        }

        int k = (sum - S) / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {//j从0开始，不是初始化状态，而是一个需要计算的状态。因为target可能为0
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][k];
    }
}
