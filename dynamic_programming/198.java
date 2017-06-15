public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int dp1 = 0, dp2 = nums[0];
        for(int i = 2; i <= n; ++i){
            int temp = dp2;
            dp2 = Math.max(dp1 + nums[i - 1], dp2);
            dp1 = temp;
        }
        return dp2;
    }
}

//public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp1 = 0, dp2 = 0;
        for(int i = 1; i <= n; ++i){
            int temp = dp2;
            dp2 = Math.max(dp1 + nums[i - 1], dp2);
            dp1 = temp;
        }
        return dp2;
    }
}
