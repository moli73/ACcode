public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int min = 0, sum = 0, res = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i){
            sum += nums[i];
            if(res < sum - min) res = sum - min;
            if(min > sum) min = sum;
        }
        return res;
    }
}
